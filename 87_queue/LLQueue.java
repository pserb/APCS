import java.util.LinkedList;

/*
Team Won (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
2022--04--01
HW87 Queues
Time Spent: 0.3 hrs
*/

// Right end of LinkedList (last) is end of Queue (last)
// Left end of LinkedList (first) is start of Queue (first)

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
