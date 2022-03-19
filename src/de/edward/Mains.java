package de.edward;

import java.util.Scanner;

public class Mains {

    //private final int[] count = new int[26]; //no documentation

    Mains() {

        Scanner scn2 = new Scanner(System.in);

        System.out.print("""


                 Ceasar's Cypher
                 This is a tool for en- and decrypting text with the famous "Ceasar's Cypher".
                 In order to use this tool properly you must take attention to the following:
                 -Only use the standard latin letters "a" to "z" or Umlaute.
                 -Only use lowercase letters
                 -Avoid using a key which is a multiple of 26
                 -Pray to God that the program will run properly
                \s
                 In order to decipher Text.
                 -Enter the key with a minus character up front.
                 -Enter cipher text.
                 -Observe magic.""");


        /*
        char k = 'a';
        char h = 'b';
        //System.out.println((char)(k + 'b'));
        System.out.println(Character.getNumericValue(k));   //10
        System.out.println(Character.getNumericValue(h));   //11
         */


        System.out.print("\n Enter Text to process: \n");
        //Plain text
        String plain = scn2.nextLine();
        System.out.print("\n\n Enter Key: \n");     //TODO: Fix the repetition
        String key = scn2.nextLine();
        System.out.print("\n Key: " + key + " ; Text to be en-/decrypted: " + plain);

        //Encrypted text
        StringBuilder encrpt = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char c = plain.charAt(i); //Character to be processed
            int t2 = Character.getNumericValue(key.charAt(i)) - 10;

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
        The first task called to turn Umlaute into their written version ("ä" to "ae" and so on...)
        However I'm not willing to do so because I'm a lazy fuck.
        I'll mitigate this issue by prompting the user to simply only enter the letters "a" to "z"

        Edit: Turns out I'm not that lazy.

        The second task calls for a for-loop which turns each letter from the "plain" string into
        into a char "c". This char is then to be encrypted using the method "encrypt()"
        This char is then to be added to the String "encrpt"
        inside of that loop:
        encrpt += Character.toString( encrypt(c));

        Edit: Used the append function instead.
        */

    /*
    For personal reference:
     Integer.parseInt(); //Grab Int from String
     Character.toString(); //Name explains it  //Can be replaced with append, given the situation.
    */

        /*
        If it is not a letter, just leave it as is
        If it is a minuscule, transform it into a majuscule
        If it is a majuscule use count[c-'A']++; to count it
        Now shift it by "key" positions to the right in the alphabet

        Remnant of the JFrame stuff.
        */

    /*
    private void statistics() {  //Don't know the purpose of this. I assume it is a remnant of Wiele's JFrame debauchery.
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            System.out.print("\n\n " + Character.toString('a' + i) + " : " + count[i]);
            sum += count[i];
        }
        System.out.print("\n\n Altogether " + sum + " letters.\n\n");
    }
     */

    public static void main(String[] args) {
        Mains e = new Mains();
        System.out.print("\n ======= This code has been provided by TheBoringEdward =======");
    }
}
