import java.util.ArrayList;

/*
Team Won (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
2022--04--01
HW87 Queues
Time Spent: 0.3 hrs
*/

// Right end of ArrayList is end of Queue
// Left end (index 0) of ArrayList is start of Queue

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
