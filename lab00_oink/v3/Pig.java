/***
 * NAMESPACE (Orion Roven, Max Schneider, Paul Serbanescu)
 * APCS
 * Lab00 - Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-08r
 * time spent: 2hrs
 *

 * DISCO:
 * How to use Scanner class in Java, and it's two methods hasNext() and next()
 * hasNext() returns bool: checks for additional lines in bitstream (words.in)
 * next() returns the next line of the bitstream, in order, from top to bottom
 * sc.nextLine() allows the scanner to read whitespace as part of the word and not different words.
 *EX: -- USING sc.next()
        $ Hello World 
        $ Ellohay
        $ Orldway

        EX: -- USING sc.nextLine()
        $ Hello World
        $ Ellohay Orldway
 *
 * QCC:
 *Is it viable to have a scanner and an enhance for loop in the main method. We tried it but it was very clunky.
 *Is there a way to have every submethod in the engToPig return an answer instead of having some build on to ans and some not
*HOW WE UTILIZED SCANNER DEMO
* we put it into out main method as a way to add inputs to the class. 
*CAUSES THE RUNTIME ERROR
*The runtime error is caused by the fact that the demo called of rthe next two words. This caused an error when there was only one word remaining. You could just remove the second one and that fixed the problem
 * NEW IN V2 - USE OF SCANNER CLASS TO USE TEST CASES FROM words.in
 * Functionality for sentences
 * Y is used appropriately
 *
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ V3 ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

import java.util.Scanner; // import scanner class

public class Pig {

    private static final String VOWELS = "aeiouyAEIOUY";
    private static final String CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PUNCS = ".,:;!?";

    public static boolean hasA(String w, String letter) {
        return w.indexOf(letter) != -1;
    }

    public static boolean isAVowel(String letter) {
        return VOWELS.indexOf(letter) != -1;
    }

    public static int countVowels(String w) {
        return allVowels(w).length();
    }

    public static boolean hasAVowel(String w) {
        return countVowels(w) != 0;
    }

    public static String allVowels(String w) {

        String ans = ""; //init return String

        for (int i = 0; i < w.length(); i++) {

            if (isAVowel(w.substring(i, i + 1)))
                ans += w.substring(i, i + 1); //grow the return String
        }
        return ans;
    }

    public static String firstVowel(String w) {

        String ans = "";
        if (hasAVowel(w)) {
            ans = allVowels(w).substring(0, 1);
        }

        return ans;
    }

    public static boolean beginsWithVowel(String w) {
        return isAVowel(w.substring(0, 1));
    }

    public static boolean isPunc(String symbol) {
        return PUNCS.indexOf(symbol) != -1;
    }

    public static boolean isUpperCase(String letter) {
        return CAPS.indexOf(letter) != -1;
    }

    public static boolean hasPunc(String w) {
        return PUNCS.indexOf(w.substring(w.length() - 1)) != -1;
    }

    public static boolean beginsWithUpper(String w) {
        return isUpperCase(w.substring(0, 1));
    }

    public static int isSentence(String w) {
        for (int i = 0; i < w.length(); i++) {
            if (w.substring(i, i + 1).equals(" ")) {
                return i;
            }
        }
        return -1;
    }

    public static boolean beginsY(String w) {
        if (w.toLowerCase().substring(0, 1).equals("y")) {
            return true;
        } else {
            return false;
        }
    }

    // ===== BEEFY CODE UNDER HERE =====

    public static String engToPig(String w) {

        String ans = "";

        // handles words with punctuation - small limitation, but we always assume punctuation occurs at the end of a word
        if (hasPunc(w)) {
            ans = engToPig(w.substring(0, w.length() - 1)) + w.substring(w.length() - 1);
            return ans;
        }//end
        
        // assigns spaceIndex the value of the index of the first space
        int spaceIndex = isSentence(w);
        //Returns the translation of the first word and then adds the other words. Uses a recursive call.
        if (spaceIndex > 0) {
            return engToPig(w.substring(0, spaceIndex)) + " " + engToPig(w.substring(spaceIndex + 1));
        }//end

        // if the word has no vowels, just add "ay" to the end of it
        if (hasAVowel(w) == false) {
            ans = w + "ay";
            return ans;
        }//end

        // if the word begins with a vowel that is NOT y, add "way" to the end of the word, otherwise, treat the first letters as consonants, (if y is the first letter it's a consonant), then go until the first vowel (this now includes y as a vowel), moving all consonants to the end, and adding "ay"
        if (beginsWithVowel(w) && !(beginsY(w))) {
            ans = w + "way";
        } else {
            int vPos = w.indexOf(firstVowel(w.substring(1)));
            ans = w.substring(vPos) + w.substring(0, vPos) + "ay";
        }//end

        // handles words with uppercases, if the first letter of the input word is uppercase, take engToPig output, set its first letter uppercase, and all letters after lowercase.
        /*
          EX:
          Hello -> elloHay
          we capitalize 'e', lowercase every letter after
          elloHay -> Ellohay
        */
        if (beginsWithUpper(w)) {
            ans = ans.substring(0, 1).toUpperCase() + ans.substring(1).toLowerCase();

        }
        return ans;

    } //end engToPing()

    public static void main(String[] args) {
        // instantiate new scanner
        Scanner sc = new Scanner(System.in);

        // using scanner for engToPig
        while (sc.hasNext()) {
            // Found using Java Platform SE 7 documentation about the Scanner class
            // https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
            // VERY CRITICAL -- nextLine() method!!
            // allows scanner to read whitespace as part of the word (CRITICAL FOR SENTENCES) -- otherwise, the scanner would split a sentence into its words
            /*
              EX: -- USING sc.next()
              $ Hello World 
              $ Ellohay
              $ Orldway

              EX: -- USING sc.nextLine()
              $ Hello World
              $ Ellohay Orldway
            */
            System.out.println(engToPig(sc.nextLine()));
        }



    } //end main()

} //end class Pig
