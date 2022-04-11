import java.util.LinkedList;

public class LLQueue<E> implements Queue<E> {
  private LinkedList<E> list = new LinkedList<>();

  public boolean add(E e) {
    return list.add(e);
  }

  public E remove() {
    return list.remove();
  }

  public E peek() {
    return list.peek();
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
