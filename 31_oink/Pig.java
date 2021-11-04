/***
 * Paul Serbanescu
 * APCS
 * HW31 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
 * 2021-11-03
 * time spent: 0.4hrs
 * 
 * DISCO:
 * you can define constants in java by adding the keyword final to the declaration
 * naming convention: final variable names are in all-caps ex: VOWELS
 * 
 * QCC:
 * is there a built in java method or maybe an enhanced for loop for Strings that allows us to bypass
 * using for String.length() loops and .substring?
 * 
 * 
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
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

public class Pig
{
  //Q: How does this initialization make your life easier?
  //A: This initialization defines the vowels we are serching for and 
  //   lets us refer to the variable name instead of typing out the vowels each time
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    for (int i = 0; i < w.length(); i++) {
        if (w.substring(i, i+1).equals(letter)) {
            return true;
        }
    } return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    return hasA(VOWELS, letter);
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    int count = 0;
    for (int i = 0; i < w.length(); i++) {
        if (isAVowel(w.substring(i, i+1))) {
            count++;
        }
    } return count;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    for (int i = 0; i < w.length(); i++) {
        if (isAVowel(w.substring(i, i+1))) {
            return true;
        }
    } return false;
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    String result = "";
    for (int i = 0; i < w.length(); i++) {
        if (isAVowel(w.substring(i, i+1))) {
            result += w.substring(i, i+1);
        }
    } return result;
  }


  public static void main( String[] args ) 
  {
    System.out.println("== Test hasA ==");
    System.out.println(hasA("cat", "a"));
    System.out.println(hasA("cat", "p"));

    System.out.println("\n== Test isAVowel ==");
    System.out.println(isAVowel("a"));
    System.out.println(isAVowel("z"));

    System.out.println("\n== Test countVowels ==");
    System.out.println(countVowels("meatballs"));
    System.out.println(countVowels("mississippi"));

    System.out.println("\n== Test hasAVowel ==");
    System.out.println(hasAVowel("cat"));
    System.out.println(hasAVowel("zzz"));

    System.out.println("\n== Test allVowels ==");
    System.out.println(allVowels("meatball"));
    System.out.println(allVowels("mississippi"));
    System.out.println(allVowels("zzz")); // prints empty string
  }//end main()

}//end class Pig