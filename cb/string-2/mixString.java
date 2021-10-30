public class mixString {
    public static String mixString(String a, String b) {
        String result = "";
        String longest = "";
        String shortest = "";

        if (a.length() > b.length()) {
            longest = a;
            shortest = b;
        } else {
            longest = b;
            shortest = a;
        }

        for (int i = 0; i < longest.length(); ++i) {
            if (i == shortest.length()) {
                result += longest.substring(i, longest.length());
                break;
            }
            result += a.charAt(i);
            result += b.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(mixString("abc", "xyz"));
        System.out.println(mixString("Hi", "There"));
        System.out.println(mixString("xxxx", "There"));
    }
}
