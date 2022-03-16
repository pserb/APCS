// WON (Brian, Paul, Ethan)
//APCS
//HW 77 -- Insert Remove -- Linked Lists
//2020--03--15
//time spent: .2 hours

/***
 * interface List
 * subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *
 * If placed in current working dir, will be consulted instead of
 *  built-in Java library interface.
 *
 * new in version 2.0:
 * REMOVE
 **/

public interface List
{
  //add node to list, containing input String as its data
  public boolean add( String x );

  //insert node at specified index
  public void insert( String x, int index );

  //remove node from list, return its data
  public String remove( int index );

  //return data in element at position i
  public String get( int i );

  //overwrite data in element at position i
  public String set( int i, String x );

  //return length of list
  public int size();

}//end interface
