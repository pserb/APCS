public class repeatFront {
    public static String repeatFront(String str, int n) {
        String answer = "";
        for (int i = 0; i < n; ++i) {
            answer += str.substring(0, n - i);
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(repeatFront("Chocolate", 4));
        System.out.println(repeatFront("Chocolate", 3));
        System.out.println(repeatFront("Ice Cream", 2));
    }
}
