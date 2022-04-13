import java.util.Iterator;

/*
Team WON (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
HW90 -- Swabbing the Deque / Double Ended Queues / Implementing Deques using Java
2022-04-12
time spent: 0.3 hrs
*/

public interface Deque<E> {
  public E peekFirst();
  public E peekLast();
  public void addFirst(E e);
  public void addLast(E e);
  public E removeFirst();
  public E removeLast();
  public boolean contains(E e);
  public int size();
  public boolean isEmpty();
  
  // added on 4/13/22
  public Iterator<E> iterator();
  public Iterator<E> descendingIterator();

  public boolean removeFirstOccurrence(Object o);
  public boolean removeLastOccurrence(Object o);
}
