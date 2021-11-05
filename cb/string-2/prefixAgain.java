public class prefixAgain {
    public static boolean prefixAgain(String str, int n) {
        String prefix = "";
        for (int i = 0; i < n; i++) {
            prefix += str.substring(i, i+1);
        }
        for (int i = prefix.length(); i <= str.length()-prefix.length(); i++) {
            if (str.substring(i, i+prefix.length()).equals(prefix)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(prefixAgain("abXYabc", 1));
        System.out.println(prefixAgain("abXYabc", 2));
        System.out.println(prefixAgain("abXYabc", 3));
    }
}
