/*
Team WON (Paul Serbanescu, Ethan Lam, Brian Wang)
APCS pd 6
03--24--2022
Time spent: .4 hrs
*/

/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
  - Iterator can directly modify the list, as it acts on top of int
    Namely, it walks over the list for us, and can do things like remove the current element
  - Iterator only knows the current element and if there is a next element.
    It has eyes but no brain.
    It can tell us what it sees but not process or store any values.
  - Iterator has its own remove because we would otherwise be modifying the index
    That would mess up using the list's remove over the iterator's remove
  - Iterator returns Object instead of the type of the list

    QCC
  - Why do we have to typecast from Object?
      ItrWork.java:86: error: incompatible types: Object cannot be converted to Integer
          Integer newVal = itr.next();
    namely, why does it not inherit the type of the list it is created on?
  - Why does java not autobox object types in something like the above error?



    SUMMARY THE FIRST:
    Iterator seemed very similar to scanner (even down to the methods).
    We did find remove confusing because we didn't think that the iterator on a list could modify it
    Simple yet confusing

    SUMMARY THE SECOND:
    Iterator is very intuitive, simple, and foolproof
    It allows us to easily traverse through any list like a linked list, without care for indexes
    We can easily just go through the list and modify said list
    Remove very useful to avoid problems with indexes, as the entirety of iterator seems to ignore indexes
    No worry about keeping track of counters
    Very Python like


**/




import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    for(Integer k : L){
      if(k.equals(key)){
        return true;
      }
    }
    return false;
  }

  //explicitly using an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator itr = L.iterator();
    while(itr.hasNext()){
      if(itr.next().equals(key)){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    List<Integer> ret = new ArrayList();
    for(Integer i : L){
      if(i%2!=0){
        ret.add(i);
      }
    }
    return ret;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator itr = L.iterator();
    List<Integer> ret = new ArrayList();
    while(itr.hasNext()){
      Integer newVal = (Integer)itr.next();
      if(newVal % 2 != 0){
        ret.add(newVal);
      }
    }
    return ret;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    /*** YOUR IMPLEMENTATION HERE ***/
    Iterator itr = L.iterator();
    while(itr.hasNext()){
      if((Integer)itr.next() % 2 == 0){
        itr.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList();

    for( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop
    for(Integer i : L){
      System.out.println(i);
    }


    // b) explicitly using an iterator


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
