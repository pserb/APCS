/*
Team WON (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
HW90 -- Swabbing the Deque / Double Ended Queues / Implementing Deques using Java
2022-04-12
time spent: 0.3 hrs
*/

import java.util.Iterator;
import java.util.LinkedList;

public class LLDeque<E> implements Deque<E> {
  
  private LinkedList<E> list = new LinkedList<E>();

  public E peekFirst() {
    return list.peekFirst();
  }

  public E peekLast() {
    return list.peekLast();
  }

  public void addFirst(E e) {
    list.addFirst(e);
  }

  public void addLast(E e) {
    list.addLast(e);
  }

  public E removeFirst() {
    return list.removeFirst();
  }

  public E removeLast() {
    return list.removeLast();
  }

  public boolean contains(E e) {
    return list.contains(e);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }

  public Iterator<E> iterator() {
    return list.iterator();
  }

  public Iterator<E> descendingIterator() {
    return list.descendingIterator();
  }

  public boolean removeFirstOccurrence(Object o) {
    return list.removeFirstOccurrence(o);
  }
  public boolean removeLastOccurrence(Object o) {
    return list.removeLastOccurrence(o);
  }

  public String toString() {
    return list.toString();
  }
}


