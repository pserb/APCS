/*
*/

public class QueueTester {
  public static void main(String[] args) {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    LLQueue<Integer> queue = new LLQueue<>();
    // ALQueue<Integer> queue = new ALQueue<>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    System.out.println("peeking front: " + queue.peek());

    System.out.println("dequeueing...");
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue.remove());

    System.out.println("is empty? " + queue.isEmpty());
  }
}
