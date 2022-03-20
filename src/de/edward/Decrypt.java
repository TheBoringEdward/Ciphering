package de.edward;

import java.util.Scanner;

public class Decrypt {

    //private final int[] count = new int[26]; //no documentation

    Decrypt() {

        Scanner scn2 = new Scanner(System.in);

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
        StringBuilder keyrep = new StringBuilder();

        for (int i = 0; i < plain.length(); i++) {
            char m = key.charAt(i % key.length());
            keyrep.append(m);
        }

        System.out.print("\n Key: " + keyrep + " ; Text to be decrypted: " + plain);

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
        Decrypt e = new Decrypt();  //Intellij always jells at me here for some reason
        System.out.print("\n ======= This code has been provided by TheBoringEdward =======");
    }
}
