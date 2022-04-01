/***
Team WON: Paul Serbanescu, Brian Wang, Ethan Lam
APCS
HW86 - What a Racket - NO NOT AGAIN NOT THIS
2022 - 03 - 31
Time Spent: 0.5 hrs probably

Disco:
  String manipulation in java to this extent is REALLY annoying
  Stacks do help a lot

QCC:
  Division?

  ALGORITHIM for EVALUATING A SCHEME EXPRESSION:
  1. Split the string into a string array seperated by spaces
  2. For each element in the string array starting from the end, push that element to a stack
  3. If the current element being added is a open parenthesis:
        Pop the current element (open paren)
        Pop the current element and save it as a string for operator (+/-/*)
        Pop the current element and save it as a result value (number)
        while the next element is not a close parenthesis:
          Check the operator saved previously, and perform that operator on res and the return value of another call of Pop
        Once a close parenthesis is hit, pop the parenthesis and push the res value
  4. Continue loading elements until the stack is reduced to one number
  5. Return number 

 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: ____ by ____
 * b/c ...

 * expr.split("\\s+")
 **/

import java.util.Stack;

public class Scheme
{
  /***
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   **/
  public static String evaluate( String expr )
  {
    String[] ex = expr.split("\\s+");
    Stack<String> stk = new Stack<>();

    for (int i = ex.length-1; i >= 0; i--) {
      stk.push(ex[i]);

      if (stk.peek().equals("(")) {
        stk.pop();
        String op = stk.pop();
        int oper = 0;
        //System.out.println(Integer.parseInt(stk.peek()));
        int res = Integer.parseInt(stk.pop());
        while (!stk.peek().equals(")")) {
          if(op.equals("+")){
            res += Integer.parseInt(stk.pop());
          }
          else if(op.equals("-")){
            res -= Integer.parseInt(stk.pop());
          }
          else if(op.equals("*")){
            res *= Integer.parseInt(stk.pop());
          }
        }
        stk.pop();
        //System.out.println(res);
        stk.push(String.valueOf(res));
      }
    }

    return stk.pop();
  }//end evaluate()


  /***
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   **/
  // public static String unload( int op, Stack<String> numbers )
  // {
  //
  // }//end unload()


  /*
  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
  }
  catch( NumberFormatException e ) {
  return false;
  }
  }
  */


  //main method for testing
  public static void main( String[] args )
  {

      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main()

}//end class Scheme
