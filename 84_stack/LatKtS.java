import java.util.ArrayList;

/*
Team WON: Paul Serbanescu, Ethan Lam, Brian Wang
APCS
HW84: Stacks: What do they do?
2022-03-28
time spent: 0.4 hrs

 * class LatKtS
 * SKELETON
 * driver class for Latkes
 * Uses a stack to reverse a text string, check for sets of matching parens.
 **/

public class LatKtS
{
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

    ArrayList<String> CLOSINGS = new ArrayList<>();
    CLOSINGS.add(")");
    CLOSINGS.add("]");
    CLOSINGS.add("}");

    /**
     * arraylist.contains(object) method:
     * return indexOf(object) >= 0;
     */

    //if last char is a closing
    if (OPENINGS.contains(s.substring(s.length()-1, s.length()))) return false;

    Latkes milleFeuille = new Latkes(10);

    for (int i = 0; i < s.length(); i++) {
      String paren = s.substring(i,i+1);
      milleFeuille.push(paren);

      if (CLOSINGS.contains(paren)) { //if paren is a closing
        milleFeuille.pop();
        if (OPENINGS.indexOf(milleFeuille.pop()) != CLOSINGS.indexOf(paren)) { //if next pop is not corresponding opening
          return false;
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
