import java.util.Arrays;

// 1, 4 and 5

public class ownArrays {
    public static double[] powArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = Math.pow(a[i], 2.0);
        } return a;
    }
    
    public static int inRange(int[] a, int low, int high) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= low && a[i] < high) {
                count++;
            }
        }
        return count;
    }
    public static int[] histogram(int[] scores, int counter) {
        int[] counts = new int[counter];
        for (int i = 0; i < counts.length; i++) {
            int index = scores[i];
            counts[index]++;
        } return counts;
    }
    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4};
        int[] scores = new int[100];
        for (int i = 0; i < 100; i++) {
            scores[i] = i;
        }
        System.out.println(Arrays.toString(powArray(a)));
        System.out.println(Arrays.toString(histogram(scores, 69))); // counter can be up to and including 100 and no less than 1
    }
}
