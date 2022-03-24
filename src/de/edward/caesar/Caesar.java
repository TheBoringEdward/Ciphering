package de.edward.caesar;

import java.util.Scanner;

public class Caesar {

    //private final int[] count = new int[26]; //no documentation

    public Caesar() {

    }

    public void pr(){
        Scanner scn2 = new Scanner(System.in);

        System.out.print("\n\n  ==== Caesar Cipher ====\n"); //Or however you call it

        System.out.print("""


                 Caesar Cipher
                 This is a tool for en- and decrypting text with the famous "Caesar Cypher".
                 In order to use this tool properly you must take attention to the following:
                 -Only use latin letters "a" to "z" or Umlaute.
                    (Exceptions to this are the following (: . , ! ? ß))
                 -Only use lowercase letters
                 -Avoid using a key which is a multiple of 26 or your text will look the same
                 -Pray to your local deity that the program will run properly""");



        System.out.print("\n\n Enter Text to be processed: \n");
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");
        int key = scn2.nextInt();

        //Encrypted text
        StringBuilder replain = new StringBuilder();

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

        System.out.print("\n Key: " + key + " (Mod: "+ key % 26 +") ; Text to be processed: " + replain);

        StringBuilder proc = new StringBuilder();

        for (int i = 0; i < replain.length(); i++) {
            char c = replain.charAt(i);
            key = key % 26;

            if (c == ' '){
                proc.append(c);
            } else {
                c = (char) (c + key);
                c = ck(c);
                proc.append(c);
            }

        }
        System.out.print("\n\n Encrypted text: " + proc);

        proc.setLength(0);

        for (int i = 0; i < replain.length(); i++) {
            char c = replain.charAt(i);

            if (c == ' '){
                proc.append(c);
            } else {
                c = (char) (c - key);
                c = ck(c);
                proc.append(c);
            }

        }
        System.out.print("\n\n Decrypted text: " + proc);
    }

    private char ck (char c){
        if (c - 'z' > 0) {
            c = (char) (c - 26);
        }
        if (c - 'a' < 0) {
            c = (char) (c + 26);
        }
        return c;
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
