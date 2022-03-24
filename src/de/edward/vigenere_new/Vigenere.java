package de.edward.vigenere_new;

import java.util.Objects;
import java.util.Scanner;

public class Vigenere {

    Scanner scn2 = new Scanner(System.in);
    StringBuilder keyrep = new StringBuilder();
    StringBuilder replain = new StringBuilder();

    public Vigenere() {

    }

    public void option(){
        String q;

        System.out.print("\n\n  ==== Vigenère Cipher ====\n");
        System.out.print("\n\n Enter 1 for Encryption, or 2 for Decryption \n");
        q = scn2.nextLine();
        if (Objects.equals(q, "1")){
            en();
        }else if (Objects.equals(q, "2")){
            de();
        }else {
            System.out.print("\n\n Invalid option. Killing program...");
            System.exit(3);
        }
    }

    private void en(){

        System.out.print("""


                    Vigenère Cipher
                    This is a tool used for encrypting text with the (less) famous "Vigenère Cipher".
                    In order to use this tool properly you must take attention to the following:
                    -Only use the standard latin letters "a" to "z" or Umlaute.
                        (Exceptions to this are the following (: . , ! ? ß))
                    -Only use lowercase letters
                    -Don't use one or more spaces infront of the text you wish to process, or your program will crash
                    -Don't use spaces in your key
                    -ONLY USE THE LETTERS "a" TO "z" IN YOUR KEY!!!
                    -Pray to your local deity that the program will run properly""");


        System.out.print("\n\n Enter Text to be encrypted: \n");
        //Plain text
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");
        String key = scn2.nextLine();

        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i);
            if (c == ':') {
                replain.append(" colon");
            } else if (c == '.') {
                replain.append(" point");
            } else if (c == ',') {
                replain.append(" comma");
            } else if (c == '!') {
                replain.append(" exclamationpoint");
            } else if (c == '?') {
                replain.append(" questionmark");    //There certainly should be a better way
            } else if (c == ' ') {
                replain.append(c);
            } else if (c == 'ß') {
                replain.append("ss");
            } else if (c == 'ü') {
                replain.append("ue");
            } else if (c == 'ö') {
                replain.append("oe");    //I'm sure there's a better way to do this
            } else if (c == 'ä') {
                replain.append("ae");
            } else if (c < 'a' || c > 'z') {
                System.out.print("\n\n Illegal character in Plaintext ( " + c + " ). Killing program...\n");
                System.exit(1);
            } else {
                replain.append(c);
            }
        }

        plain = replain.toString();
        keyrep = forge(plain, key);

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
                c = ck(c);
                encrpt.append(c);
            }
        }
        System.out.print("\n\n Encrypted text: " + encrpt);
    }

    ///////////////////////////////////////////

    public void de() {

        System.out.print("""


                 Vigenère Cipher
                 This is a tool used for decrypting text with the (less) famous "Vigenère Cipher".
                 In order to use this tool properly you must take attention to the following:
                 -Enter encrypted text in all lowercase
                 -Don't use one or more spaces infront of the text you wish to process, or your program will crash
                 -Same goes for the key
                 -Pray to your local deity that the program will run properly""");


        System.out.print("\n\n Enter Text to be decrypted: \n");
        //Plain text
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");
        String key = scn2.nextLine();

        //StringBuilder replain = new StringBuilder();

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
                c = ck(c);
                decrpt.append(c);
            }
        }
        System.out.print("\n\n Decrypted text: " + decrpt);
    }

    ///////////////////////////////////////////

    private char ck (char c){
        if (c - 'z' > 0) {
            c = (char) (c - 26);
        }
        if (c - 'a' < 0) {
            c = (char) (c + 26);
        }
        return c;
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
