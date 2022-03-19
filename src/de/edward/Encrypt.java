package de.edward;

import java.util.Scanner;

public class Encrypt {

    //private final int[] count = new int[26]; //no documentation

    Encrypt() {

        Scanner scn2 = new Scanner(System.in);

        System.out.print("""


                 Vigenère Cipher
                 This is a tool for encrypting text with the (less) famous "Vigenère Cipher".
                 In order to use this tool properly you must take attention to the following:
                 -Only use the standard latin letters "a" to "z" or Umlaute.
                 -Only use lowercase letters
                 -Don't use spaces in your key
                 -Pray to God that the program will run properly""");


        System.out.print("\n\n Enter Text to be processed: \n");
        //Plain text
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");     //TODO: Fix the repetition
        String key = scn2.nextLine();
        StringBuilder keyrep = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char m = key.charAt(i % key.length());
            keyrep.append(m);
        }

        System.out.print("\n Key: " + keyrep + " ; Text to be en-/decrypted: " + plain);

        //Encrypted text
        StringBuilder encrpt = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i); //Character to be processed
            int t2 = Character.getNumericValue(keyrep.charAt(i)) - 10; //The minus ten is necessary due to the numeric value of characters is always plus 10 (or 9, to be precise).

            if (c == ' '){
                encrpt.append(c);
            }else if (c == 'ü'){
                c = (char) ('u' + t2);
                c = ck(c);
                encrpt.append(c);
                c = (char) ('e' + t2);
                c = ck(c);
                encrpt.append(c);       //This is terrible.
            }else if (c == 'ö'){
                c = (char) ('o' + t2);
                c = ck(c);
                encrpt.append(c);
                c = (char) ('e' + t2);
                c = ck(c);
                encrpt.append(c);       //This is terrible.
            }else if (c == 'ä'){
                c = (char) ('a' + t2);
                c = ck(c);
                encrpt.append(c);
                c = (char) ('e' + t2);
                c = ck(c);
                encrpt.append(c);       //This is terrible.
            }else {
                c = (char) (c + t2);
                c = ck(c);
                encrpt.append(c);
            }
        }
        System.out.print("\n\n Encrypted text: " + encrpt);
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

      By all means, this project was just me doing absolute nonsense.
      However, for some reason, this project worked out MUCH smoother than I could've ever anticipated

        */

    public static void main(String[] args) {
        Encrypt e = new Encrypt();  //Intellij always jells at me here for some reason
        System.out.print("\n ======= This code has been provided by TheBoringEdward =======");
    }
}
