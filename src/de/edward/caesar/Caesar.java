package de.edward.caesar;

import de.edward.Outer;

import java.util.Scanner;

public class Caesar {

    //private final int[] count = new int[26]; //no documentation

    public Caesar() {

    }

    public void pr(){
        Scanner scn2 = new Scanner(System.in);
        Outer ot = new Outer();

        System.out.print("\n\n  ==== Caesar Cipher ====\n"); //Or however you call it

        ot.cae(1);

        System.out.print("\n\n Enter Text to be processed: \n");
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");
        int key = scn2.nextInt();

        //Encrypted text
        StringBuilder replain = ot.rpln(plain);

        System.out.print("\n Key: " + key + " (Mod: "+ key % 26 +") ; Text to be processed: " + replain);

        StringBuilder proc = new StringBuilder();

        for (int i = 0; i < replain.length(); i++) {
            char c = replain.charAt(i);
            key = key % 26;

            if (c == ' '){
                proc.append(c);
            } else {
                c = (char) (c + key);
                c = ot.ck(c);
                proc.append(c);
            }

        }

        ot.check(proc);
        System.out.print("\n\n Encrypted text: " + proc);

        //////////////////////

        proc.setLength(0);

        //////////////////////

        for (int i = 0; i < replain.length(); i++) {
            char c = replain.charAt(i);

            if (c == ' '){
                proc.append(c);
            } else {
                c = (char) (c - key);
                c = ot.ck(c);
                proc.append(c);
            }

        }

        ot.check(proc);
        System.out.print("\n\n Decrypted text: " + proc);
    }

    /*
    For personal reference:
     Integer.parseInt(); //Grab Int from String
     Character.toString(); //Name explains it  //Can be replaced with append, given the situation.
    */

    public static void main(String[] args) {
        Caesar e = new Caesar();
        e.pr();
        System.out.print("\n\n ======= This code has been provided by TheBoringEdward =======");
    }
}
