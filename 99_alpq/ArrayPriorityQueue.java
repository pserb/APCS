// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS pd6
// HW99 -- Some Are More Equal Than Others, Codified
// 2022-05-13f
// time spent: 0.5 hrs

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {

    private ArrayList<Integer> list;

    public ArrayPriorityQueue() {
        list = new ArrayList<Integer>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void add(int x) {
        list.add(x);
    }

    public int getMinIndex() {
        int ret = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(ret)) {
                ret = i;
            }
        }

        return ret;
    }

    public int peekMin() {
        // search and return
        return list.get(getMinIndex());
    }

    public int removeMin() {
        return list.remove(getMinIndex());
    }

    public static void main(String[] args) {
        ArrayPriorityQueue apQ = new ArrayPriorityQueue();

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
    }
}
