/**
* Interface Queue<E>
*/

public interface Queue<E> {
  public boolean add(E e);
  public E remove();
  public E peek();
  public boolean isEmpty();
}
