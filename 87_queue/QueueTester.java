public class QueueTester {
  public static void main(String[] args) {
    ///
    // LLQueue<Integer> queue = new LLQueue<>();
    ALQueue<Integer> queue = new ALQueue<>();
    ///

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);

    System.out.println("peeking front: " + queue.peekFront());

    System.out.println("dequeueing...");
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());

    System.out.println("is empty? " + queue.isEmpty());
  }
}
