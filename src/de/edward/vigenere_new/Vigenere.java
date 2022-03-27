package de.edward.vigenere_new;

import de.edward.Outer;

import java.util.Objects;
import java.util.Scanner;

public class Vigenere {

    Scanner scn2 = new Scanner(System.in);
    Outer ot = new Outer();
    StringBuilder keyrep = new StringBuilder();
    StringBuilder replain = new StringBuilder();

    public Vigenere() {

    }

    public void option(){
        String q;

        System.out.print("\n\n  ==== Vigenère Cipher ====\n");
        System.out.print("\n\n Enter 1 for Encryption, or 2 for Decryption \n");
        q = scn2.nextLine();
        if (Objects.equals(q, "1")){ //I'm not entirely sure what Intellij did here
            ot.vig(Integer.parseInt(q));
            en();
        }else if (Objects.equals(q, "2")){
            ot.vig(Integer.parseInt(q)); //*Sniffing glue* WE GOTTA AUTOMATE THIS SHIT!!!
            de();
        }else {
            System.out.print("\n\n Invalid option. Killing program...");
            System.exit(3);
        }
    }

    private void en(){

        replain = ot.rpln(enterP(1));
        String key = enterK();

        keyrep = forge(replain.toString(), key);

        System.out.print("\n Key: " + key + " ; Text to be encrypted: " + replain);

        //Encrypted text
        StringBuilder encrpt = new StringBuilder();

        int e = 0;

        for (int i = 0; i < replain.length(); i++) {
            char c = replain.charAt(i); //Character to be processed
            int t2 = Character.getNumericValue(keyrep.charAt(i - e)) - 10; //The minus ten is necessary due to the numeric value of characters is always plus 10 (or 9, to be precise).

            //This was much more complicated to solve than it should've been

            if (c == ' ') {
                encrpt.append(c);
                e += 1;
            } else {
                c = (char) (c + t2);
                c = ot.ck(c);
                encrpt.append(c);
            }
        }
        ot.check(encrpt);
        System.out.print("\n\n Encrypted text: " + encrpt);
    }

    ///////////////////////////////////////////

    public void de() {

        String plain = enterP(2);
        String key = enterK();

        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i);
            if (c == ' '){
                //Do nothing
            }else if (c < 'a' || c > 'z'){
                System.out.print("\n\n Illegal character in Plaintext ( "+c+" ). Killing program...\n");
                System.exit(1);
            }
        }

        keyrep = forge(plain, key);

        System.out.print("\n Key: " + key + " ; Text to be decrypted: " + plain);

        //Encrypted text
        StringBuilder decrpt = new StringBuilder();

        int e = 0;

        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i); //Character to be processed
            int t2 = Character.getNumericValue(keyrep.charAt(i - e)) - 10;

            if (c == ' '){
                decrpt.append(c);
                e += 1;
            }else {
                c = (char) (c - t2);
                c = ot.ck(c);
                decrpt.append(c);
            }
        }
        ot.check(decrpt);
        System.out.print("\n\n Decrypted text: " + decrpt);
    }

    ///////////////////////////////////////////

    private String enterP(int i1){
        if (i1 == 1){
            System.out.print("\n\n Enter Text to be encrypted: \n");
        } else if (i1 == 2){
            System.out.print("\n\n Enter Text to be decrypted: \n");
        } else {
            System.out.print("\n\n Invalid prompt. ( "+i1+" ). Check program! Killing program...\n");
            System.exit(5);
        }
        //Plain text
        return scn2.nextLine();
    }

    private String enterK(){
        System.out.print("\n\n Enter Key: \n");
        return scn2.nextLine();
    }

    ///////////////////////////////////////////

    private StringBuilder forge(String plain, String key){
        StringBuilder rep = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char m = key.charAt(i % key.length());
            rep.append(m);
            if (m < 'a' || m > 'z'){
                System.out.print("\n\n Illegal character in Key ( "+m+" ). Killing program...\n");
                System.exit(2);
            }
        }
        return rep;
    }

    ///////////////////////////////////////////

    public static void main(String[] args) {
        Vigenere e = new Vigenere();
        e.option();
        System.out.print("\n\n ======= This code has been provided by TheBoringEdward =======\n");
    }
}
