import java.util.ArrayList;

/***
 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{
  // public static final String[] OPENINGS = {"(", "[", "{"};
  public static final String[] CLOSINGS = {")", "]", "}"};

  /***
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("stressed") -> "desserts"
   **/
  public static String flip( String s )
  {
    Latkes cake = new Latkes(10);
    for (int i = 0; i < s.length(); i++) {
      cake.push(s.substring(i,i+1));
    }

    String reverso = "";
    for (int i = 0; i < s.length(); i++) {
      reverso += cake.pop();
    }
    return reverso;
  }


  /***
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **/
  public static boolean allMatched( String s )
  {
    ArrayList<String> OPENINGS = new ArrayList<>();
    OPENINGS.add("(");
    OPENINGS.add("[");
    OPENINGS.add("{");

    if (OPENINGS.contains(s.substring(s.length()-1, s.length()))) return false;

    Latkes milleFeuille = new Latkes(10);
    for (int i = 0; i < s.length(); i++) {
      String letter = s.substring(i,i+1);
      milleFeuille.push(letter);

      for (int j = 0; j < CLOSINGS.length; j++) {
        if (letter.equals(CLOSINGS[j])) { // letter is a closing paren
          milleFeuille.pop();
          if (OPENINGS.indexOf(milleFeuille.pop()) != j) {
            return false;
          }
        }
      }
    }
    return true;
  }


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class