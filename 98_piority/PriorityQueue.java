// Integer version of PriorityQueue

public interface PriorityQueue<T> {
    public void add(T x);
    public boolean isEmpty();
    public T peekMin();
    public T removeMin();
}
