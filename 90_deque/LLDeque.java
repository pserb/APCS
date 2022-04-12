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
}
