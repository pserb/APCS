public interface Deque<E> {
  public E peekFirst();
  public E peekLast();
  public void addFirst(E e);
  public void addLast(E e);
  public E removeFirst();
  public E removeLast();
  public boolean contains(E e);
  public int size();
  public boolean isEmpty();
}
