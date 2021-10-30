public class endOther {
    public static boolean endOther(String a, String b) {
        String aLow = a.toLowerCase();
        String bLow = b.toLowerCase();

        if (aLow.length() > bLow.length()) {
            return ((aLow.substring(aLow.length() - bLow.length(), aLow.length())).equals(bLow));
        } return ((bLow.substring(bLow.length() - aLow.length(), bLow.length())).equals(aLow));
    }
    public static void main(String[] args) {
        System.out.println(endOther("Hiabc", "abc"));
        System.out.println(endOther("AbC", "HiaBc"));
        System.out.println(endOther("abc", "abXabc"));

        System.out.println(endOther("ab", "ab12"));
    }
}
