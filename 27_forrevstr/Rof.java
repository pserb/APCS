/*
Paul Serbanescu, Max Schneider, Andrew Piatesky
HW27 - FOR the Love of Strings
2021-10-28
0.5

DISCO:
Recursion is much more elgant, but for loops are much easier to impelemnt (and take less time)

QCC:
is there a better way of doing this than using substring()? maybe charAt or some other method?
*/

public class Rof {

    public static String fenceF(int posts) {
        String result = "|";
        for (int i = 1; i < posts; ++i) {
            result += "--|";
        }
        return result;
    }

    public static String reverseF(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            result += s.substring(i, i + 1);
        }
        return result;
    }

    public static String reverseR(String s) {
        int len = s.length();

        if (len == 1) { return s; }

        return s.substring(len - 1, len) + reverseR(s.substring(0, len - 1));
    }

    public static void main(String[] args) {
        // Test fenceF
        System.out.println("== Test fenceF ==");
        System.out.println(fenceF(1));
        System.out.println(fenceF(2));
        System.out.println(fenceF(3));

        // Test reverseF
        System.out.println("\n== Test reverseF ==");
        System.out.println(reverseF("stressed"));

        // Test reverseR
        System.out.println("\n== Test reverseR ==");
        System.out.println(reverseR("stressed"));
    }
}