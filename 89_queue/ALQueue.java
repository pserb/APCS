import java.util.ArrayList;

/**
* class ALQueue<E> implements Queue<E>.
* Implementation using an ArrayList
*/

public class ALQueue<E> implements Queue<E> {
  private ArrayList<E> list = new ArrayList<>();

  /**
  * passes through ArrayList {@link ArrayList#add() add} functionality
  * O(1) runtime
  *
  * @param e value to be added
  * @return true
  */
  public boolean add(E e) {
    return list.add(e);
  }

  /**
  * passes through ArrayList {@link ArrayList#remove(int index) remove} functionality
  * O(n) runtime
  *
  * @return value removed
  */
  public E remove() {
    return list.remove(0);
  }

  /**
  * passes through ArrayList {@link ArrayList#get(int index)} functionality
  * O(1) runtime
  *
  * @return frontmost value
  */
  public E peek() {
    return list.get(0);
  }

  /**
  * passes through ArrayList {@link ArrayList#isEmpty() isEmpty} functionality
  * O(1) runtime
  *
  * @return true if Queue is empty
  */
  public boolean isEmpty() {
    return list.isEmpty();
  }
}
