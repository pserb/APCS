public class repeatEnd {
    public static String repeatEnd(String str, int n) {
        String answer = "";
        for (int i = 0; i < n; ++i) {
            answer += str.substring(str.length() - n, str.length());
        }
        return answer;
    }
    public static void main(String[] args) {
        System.out.println(repeatEnd("Hello", 3));
        System.out.println(repeatEnd("Hello", 2));
        System.out.println(repeatEnd("Hello", 1));
    }
}
