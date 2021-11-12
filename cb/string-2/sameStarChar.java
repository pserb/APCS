public class sameStarChar {
    public static boolean sameStarChar(String str) {
        if (str.length() <= 2) {
            return true;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '*') {
                if (str.charAt(i-1) == str.charAt(i+1)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(sameStarChar("xy*yzz"));
        System.out.println(sameStarChar("xy*zzz"));
        System.out.println(sameStarChar("*xa*az"));
    }
}