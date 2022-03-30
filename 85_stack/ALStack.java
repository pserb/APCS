import java.util.ArrayList;

public class ALStack<T> implements Stack<T> {

  private ArrayList<T> list;

  public ALStack() {
    list = new ArrayList<T>();
  }

  public boolean isEmpty() {
    return list.size() < 1;
  }

  public T peekTop() {
    return list.get(list.size()-1);
  }

  public T pop() {
    T retVal = peekTop();
    list.remove(list.size()-1);
    return retVal;
  }

  public void push(T x) {
    list.add(x);
  }

}
