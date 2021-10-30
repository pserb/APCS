public class xyzThere {
    public static boolean xyzThere(String str) {
        if (str.length() >= 3 && str.substring(0, 3).equals("xyz")) { return true; }
        for (int i = 0; i < str.length()-3; ++i) {
            if ((str.charAt(i) != '.') && (str.substring(i+1, i+4).equals("xyz"))) {
                return true;
            }
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(xyzThere("abcxyz"));
        System.out.println(xyzThere("abc.xyz"));
        System.out.println(xyzThere("xyz.abc"));

        System.out.println(xyzThere("abcxy"));
        System.out.println(xyzThere("xy"));
        System.out.println(xyzThere("x"));

        System.out.println(xyzThere("abc.xyzxyz"));

        System.out.println(xyzThere("xyz"));
    }
}
