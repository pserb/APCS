import java.util.ArrayList;

/** Class MySorts
 * stores sorting algos: bubble sort, selection sort, insertion sort
 */

public class MySorts {

    // Exit-early version of bubble sort
    // WC: O(n^2), BC: O(n)
    public static void bubble( ArrayList<Comparable> data ) {
        boolean swapped;

        for (int i = 0; i < data.size(); i++) {
            swapped = false;
            for (int j = data.size()-1; j > i; j--) {
                Comparable p1 = data.get(j);
                Comparable p2 = data.get(j-1);
  
                if (p1.compareTo(p2) < 0) {
                    data.set(j, p2);
                    data.set(j-1, p1);
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    //this version places greatest value at "rightmost" end
    // WC: O(n^2), BC: O(n^2)
    public static void selection( ArrayList<Comparable> data ) {
        int maxPos;
        for (int pass = data.size()-1; pass > 0; pass--) {
            Comparable hi = data.get(0);

            for (maxPos = pass; maxPos > 0; maxPos--) {
                if (data.get(maxPos).compareTo(hi) > 0) {
                    hi = data.get(maxPos);
                }
            }

            Comparable p1 = data.get(pass);
            data.set(pass, hi);
            data.set(data.indexOf(hi), p1);
        }
    }

    // WC: O(n^2), BC: O(n)
    public static void insertion( ArrayList<Comparable> data ) {
        for(int partition = 1; partition < data.size(); partition++) {
            for(int i = partition; i > 0; i--) {
                if ( data.get(i).compareTo(data.get(i-1)) < 0) {
                    Comparable dummy = data.get(i);
                    data.set(i,data.get(i-1));
                    data.set(i-1,dummy);
                }
                else
                break;
            }
        }
    }

}