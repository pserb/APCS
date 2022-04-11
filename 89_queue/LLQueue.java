import java.util.LinkedList;

/**
* class LLQueue<E> implements Queue<E>.
* Implementation using a LinkedList
*/

public class LLQueue<E> implements Queue<E> {
  private LinkedList<E> list = new LinkedList<>();

  /**
   * passes through LinkedList {@link LinkedList#add() add} functionality
   * O(1) runtime
   * 
   * @param e value to be added
   * @return true
   */
  public boolean add(E e) {
    return list.add(e);
  }

  /**
   * passes through LinkedList {@link LinkedList#remove() remove} functionality
   * O(1) runtime
   * 
   * @return value removed
   */
  public E remove() {
    return list.remove();
  }

  /**
   * passes through LinkedList {@link LinkedList#peek() peek} functionality
   * O(1) runtime
   * 
   * @return firstmost value
   */
  public E peek() {
    return list.peek();
  }

  /**
   * passes through LinkedList {@link LinkedList#isEmpty() isEmpty} functionality
   * 
   * @return true if Queue is empty
   */
  public boolean isEmpty() {
    return list.isEmpty();
  }
}
