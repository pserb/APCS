public class catDog {
    public static boolean catDog(String str) {
        int nCat = 0;
        int nDog = 0;
        for (int i = 0; i < str.length()-2; i++) {
            if (str.substring(i, i+3).equals("cat")) {
                ++nCat;
            }
            if (str.substring(i, i+3).equals("dog")) {
                ++nDog;
            }
        }
        if (nCat == nDog) {
            return true;
        } return false;
    }
    public static void main(String[] args) {
        System.out.println(catDog("catdog"));
        System.out.println(catDog("catcat"));
        System.out.println(catDog("1cat1cadodog"));
    }
}