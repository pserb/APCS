import java.util.LinkedList;

public class LLQueue<T> implements Queue<T> {
  private LinkedList<T> list = new LinkedList<>();

  public T dequeue() {
    return list.removeFirst();
  }

  public void enqueue(T x) {
    list.addLast(x);
  }

  public boolean isEmpty() {
    return list.size() < 1;
  }

  public T peekFront() {
    return list.getFirst();
  }

}
