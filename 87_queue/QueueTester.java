/*
Team Won (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
2022--04--01
HW87 Queues
Time Spent: 0.3 hrs
*/

public class QueueTester {
  public static void main(String[] args) {
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // USAGE: un-comment exactly 1 assignment below
    // LLQueue<Integer> queue = new LLQueue<>();
    ALQueue<Integer> queue = new ALQueue<>();
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
