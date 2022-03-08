import java.util.ArrayList;

/*
IDK (May Qiu, Jeffery Tang, Paul Serbanescu)
APCS
HW71 -- Mysterious Method
2022-03-07
time spent: .5 hrs
DISCO
* We first thought the values to the left of the "wall" would be sorted ascendingly and
those to the right would be sorted descendingly but they were just coincidences from the
first trace.
QCC
* Is there a way to code this more efficently (i.e. not using ArrayList)?
* Is there a way to sort the left and right sides ascendingly and descendingly, respectively?
q0: The third integer input is the "wall" and the values to its left are less than it and the
values to its right are greater than it.
q1: O(n)
*/

public class Mysterion {
  //preconditions: start = 0, end = final index, wall = index of the "wall"
  //postconditions: ArrayList will be set to have values less than the "wall" to its left and have
  //values greater than the "wall" to its right.
  values to its right are greater than it.
  public static void GreatWallOfChina(ArrayList<Integer> arr, int start, int end, int wall) {
    // System.out.println("Starting array: " + arr);
    int temp;
    int v = arr.get(wall);
    temp = arr.get(wall);
    arr.set(wall, arr.get(end));
    arr.set(end, temp);
    int s = start;
    for (int i = 0 ; i < end-1 ; i++) {
      if (arr.get(i) < v) {
        temp = arr.get(s);
        arr.set(s, arr.get(i));
        arr.set(i, temp);
        s+=1;
        // System.out.println("s = " + s + ", i = " + i + ", current array: " + arr);
      }
    }
    temp = arr.get(end);
    arr.set(end, arr.get(s));
    arr.set(s, temp);
  }
  public static void main(String[] args) {
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(9);
    a.add(3);
    a.add(8);
    a.add(1);
    a.add(12);
    a.add(4);
    GreatWallOfChina(a, 0, 5, 2);
    System.out.println(a);
    ArrayList<Integer> b = new ArrayList<Integer>();
    b.add(9);
    b.add(3);
    b.add(8);
    b.add(1);
    b.add(12);
    b.add(4);
    b.add(23);
    GreatWallOfChina(b, 0, 6, 3);
    System.out.println(b);
    ArrayList<Integer> c = new ArrayList<Integer>();
    c.add(3);
    c.add(3);
    c.add(8);
    c.add(1);
    GreatWallOfChina(a, 0, 3, 1);
    System.out.println(c);
    ArrayList<Integer> d = new ArrayList<Integer>();
    d.add(9);
    d.add(-3);
    d.add(8);
    d.add(1);
    d.add(12);
    d.add(4);
    GreatWallOfChina(d, 0, 5, 2);
    System.out.println(d);
    ArrayList<Integer> e = new ArrayList<Integer>();
    e.add(9);
    e.add(3);
    e.add(8);
    e.add(1);
    e.add(12);
    e.add(4);
    e.add(13);
    e.add(16);
    e.add(6);
    GreatWallOfChina(e, 0, 8, 0);
    System.out.println(e);
  }
}
