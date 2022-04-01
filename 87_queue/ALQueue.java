import java.util.ArrayList;

public class ALQueue<T> implements Queue<T> {

  private ArrayList<T> list = new ArrayList<>();

  public T dequeue() {
    return list.remove(0);
  }

  public void enqueue(T x) {
    list.add(x);
  }

  public boolean isEmpty() {
    return list.size() < 1;
  }

  public T peekFront() {
    return list.get(0);
  }

}
