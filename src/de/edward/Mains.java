package de.edward;

import de.edward.caesar.Caesar;
import de.edward.vigenere_new.Vigenere;

import java.util.Objects;
import java.util.Scanner;

public class Mains {

    Scanner scn2 = new Scanner(System.in);

    Mains() {

    }

    void option(){
        String q;
        Vigenere v = new Vigenere();
        Caesar c = new Caesar();

        System.out.print("\n\n Enter 1 for Vigenère Cipher, or 2 for Caesar Cipher\n");
        q = scn2.nextLine();
        if (Objects.equals(q, "2")){
            c.pr();
        }else if (Objects.equals(q, "1")){
            v.option();
        } else {
            System.out.print("\n\n Invalid option. Killing program...");
            System.exit(3);
        }
    }

    public static void main(String[] args) {
        Mains m = new Mains();
        m.option();
        System.out.print("\n\n ======= This code has been provided by TheBoringEdward =======\n");
    }
}

/*
Exit codes:
    0 = Program ended
    1 = Illegal character in Plaintext
    2 = Illegal character in Key
    3 = Invalid option
    4 = Yet to be fixed
 */