import java.util.ArrayList;

public class ArrayPriorityQueue<T> implements PriorityQueue<T> {

    private ArrayList<T> list;

    public ArrayPriorityQueue() {
        list = new ArrayList<T>();
    }

    public void add(T x) {
        list.add(x);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T peekMin() {
        // search and return
        T minVal = list.get(0);
        for (T item : list) {
            if (((Comparable<T>) item).compareTo( minVal ) < 0) {
                minVal = item;
            }
        }

        return minVal;
    }

    public T removeMin() {
        T retVal = this.peekMin();
        list.remove(retVal);
        return retVal;
    }

    public static void main(String[] args) {
        ArrayPriorityQueue<Integer> apQ = new ArrayPriorityQueue<Integer>();

        apQ.add(2);
        apQ.add(4);
        apQ.add(1);
        apQ.add(7);
        apQ.add(3);

        System.out.println("Testing APQ with Integers...");
        System.out.println(apQ.removeMin()); //1
        System.out.println(apQ.removeMin()); //2
        System.out.println(apQ.removeMin()); //3
        System.out.println(apQ.removeMin()); //4
        System.out.println(apQ.removeMin()); //7


        ArrayPriorityQueue<String> apQStr = new ArrayPriorityQueue<String>();

        apQStr.add("b");
        apQStr.add("a");
        apQStr.add("c");
        apQStr.add("A");
        apQStr.add("!");

        System.out.println("\nTesting APQ with Strings...");
        System.out.println(apQStr.removeMin()); //!
        System.out.println(apQStr.removeMin()); //A
        System.out.println(apQStr.removeMin()); //a
        System.out.println(apQStr.removeMin()); //b
        System.out.println(apQStr.removeMin()); //c


        ArrayPriorityQueue<PlaneTicket> apQPlane = new ArrayPriorityQueue<PlaneTicket>();

        apQPlane.add(new PlaneTicket("Jack Harlow", "business"));
        apQPlane.add(new PlaneTicket("Freddie Mercury", "first"));
        apQPlane.add(new PlaneTicket("Ariana Grande", "economy"));
        apQPlane.add(new PlaneTicket("Kanye West", "first"));
        apQPlane.add(new PlaneTicket("Taylor Swift", "economy"));

        System.out.println("\nTesting APQ with Airplane Tickets...");
        System.out.println(apQPlane.removeMin()); //Freddie Mercury
        System.out.println(apQPlane.removeMin()); //Kanye West
        System.out.println(apQPlane.removeMin()); //Jack Harlow
        System.out.println(apQPlane.removeMin()); //Ariana Grande
        System.out.println(apQPlane.removeMin()); //Taylor Swift
    }
}
