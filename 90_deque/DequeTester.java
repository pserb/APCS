/*
Team WON (Paul Serbanescu, Brian Wang, Ethan Lam)
APCS
HW90 -- Swabbing the Deque / Double Ended Queues / Implementing Deques using Java
2022-04-12
time spent: 0.3 hrs
*/

public class DequeTester {
  public static void main(String[] args) {
    LLDeque<String> deque = new LLDeque<String>();

    // using deque as stack (FILO)
    System.out.println("Now using deque as a stack...");
    deque.addLast("hey");
    deque.addLast("wo");
    deque.addLast("ow");
    deque.addLast("o");

    System.out.println(deque.size()); //4
    System.out.println(deque.contains("ow")); //true
    System.out.println(deque.contains("owo")); //false
    System.out.println(deque.removeLast()); //o
    System.out.println(deque.removeLast()); //ow
    System.out.println(deque.removeLast()); //wo
    System.out.println(deque.removeLast()); //hey
    System.out.println(deque.isEmpty()); //true


    // using deque as queue (FIFO)
    System.out.println("\nNow using deque as a queue...");
    deque.addFirst("hey");
    deque.addFirst("wo");
    deque.addFirst("ow");
    deque.addFirst("o");

    System.out.println(deque.size()); //4
    System.out.println(deque.contains("ow")); //true
    System.out.println(deque.contains("owo")); //false
    System.out.println(deque.removeLast()); //hey
    System.out.println(deque.removeLast()); //wo
    System.out.println(deque.removeLast()); //ow
    System.out.println(deque.removeLast()); //o
    System.out.println(deque.isEmpty()); //true

    deque.addFirst("first thing");
    deque.addFirst("second");
    deque.addFirst("second");
    deque.addFirst("troid");

    System.out.println(deque);

    deque.removeFirstOccurrence("second");

    System.out.println(deque);
  }
}
