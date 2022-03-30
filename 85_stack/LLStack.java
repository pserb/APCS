import java.util.LinkedList;

public class LLStack<T> implements Stack<T> {

  private LinkedList<T> list;

  public LLStack() {
    list = new LinkedList<T>();
  }

  public boolean isEmpty() {
    return list.size() < 1;
  }

  public T peekTop() {
    return list.getLast();
  }

  public T pop() {
    return list.removeLast();
  }

  public void push(T x) {
    list.addLast(x);
  }
}
