package de.edward;

public class Outer {

    public Outer(){

    }

    public void cae(int i1){
        if (i1 == 1){
            System.out.print("""


                 Caesar Cipher
                 This is a tool for en- and decrypting text with the famous "Caesar Cypher".
                 In order to use this tool properly you must take attention to the following:
                 -Only use latin letters "a" to "z" or Umlaute.
                    (Exceptions to this are the following (: . , ! ? ß))
                 -Only use lowercase letters
                 -Avoid using a key which is a multiple of 26 or your text will look the same
                 -Pray to your local deity that the program will run properly""");
        } else {
            System.out.print("\n\n Invalid prompt. ( "+i1+" ). Check program! Killing program...\n");
            System.exit(5);
        }
    }

    public void vig(int i1){
        if (i1 == 1){
            System.out.print("""


                    Vigenère Cipher
                    This is a tool used for encrypting text with the (less) famous "Vigenère Cipher".
                    In order to use this tool properly you must take attention to the following:
                    -Only use the standard latin letters "a" to "z" or Umlaute.
                        (Exceptions to this are the following (: . , ! ? ß))
                    -Only use lowercase letters
                    -Don't use one or more spaces in-front of the text you wish to process, or your program will crash
                    -Don't use spaces in your key
                    -ONLY USE THE LETTERS "a" TO "z" IN YOUR KEY!!!
                    -Pray to your local deity that the program will run properly""");
        } else if (i1 == 2){
            System.out.print("""


                 Vigenère Cipher
                 This is a tool used for decrypting text with the (less) famous "Vigenère Cipher".
                 In order to use this tool properly you must take attention to the following:
                 -Enter encrypted text in all lowercase
                 -Don't use one or more spaces in-front of the text you wish to process, or your program will crash
                 -Same goes for the key
                 -Pray to your local deity that the program will run properly""");
        } else {
            System.out.print("\n\n Invalid prompt. ( "+i1+" ). Check program! Killing program...\n");
            System.exit(5);
        }
    }

    public void check(StringBuilder proc){
        for (int i = 0; i < proc.length(); i++) {
            char c = proc.charAt(i);
            if (c == ' '){
                //Do nothing
            }else if (c < 'a' || c > 'z') {
                System.out.print("\n\n Invalid output. ( " + c + " ). Check code! Killing program...\n");
                System.exit(4);
            }
        }
    }

    public StringBuilder rpln(String plain){
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
            } else if (c == ' ') {                  //Found a better way. Still not proud of this monstrosity.
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
        return replain;
    }

    public char ck (char c){
        if (c - 'z' > 0) {
            c = (char) (c - 26);
        }
        if (c - 'a' < 0) {
            c = (char) (c + 26);
        }
        return c;
    }

}
