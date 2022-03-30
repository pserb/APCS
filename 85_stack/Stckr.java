/***
 * class Stckr
 * SKELETON
 * driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 **/

public class Stckr
{
  public static void main( String[] args )
  {

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    Stack<String> cakes = new ALStack<String>();
    // Stack<String> cakes = new LLStack<String>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // cakes.push(5);
    // cakes.push(10);
    // System.out.println(cakes.peekTop());
    // System.out.println("POPPING " + cakes.pop());
    // System.out.println("is empty? " + cakes.isEmpty());

    cakes.push("aoo");
    cakes.push("boo");
    cakes.push("coo");
    cakes.push("doo");
    cakes.push("eoo");
    cakes.push("foo");
    cakes.push("goo");
    cakes.push("hoo");
    cakes.push("ioo");
    cakes.push("joo");
    cakes.push("coocoo");
    cakes.push("cachoo");

    //cachoo
    System.out.println( cakes.pop() );
    //coocoo
    System.out.println( cakes.pop() );
    //joo
    System.out.println( cakes.pop() );
    //ioo
    System.out.println( cakes.pop() );
    //hoo
    System.out.println( cakes.pop() );
    //goo
    System.out.println( cakes.pop() );
    //foo
    System.out.println( cakes.pop() );
    //eoo
    System.out.println( cakes.pop() );
    //doo
    System.out.println( cakes.pop() );
    //coo
    System.out.println( cakes.pop() );
    //boo
    System.out.println( cakes.pop() );
    //aoo
    System.out.println( cakes.pop() );

    //...

  }//end main

}//end class
