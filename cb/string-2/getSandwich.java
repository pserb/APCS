public class getSandwich {
    public static String getSandwich(String str) {
        int breadCount = 0;
        int firstBread = str.length();
        int lastBread = 0;

        for (int i = 0; i < str.length()-4; i++) {
            if (str.substring(i, i+5).equals("bread")) {
                breadCount++;
                if (i < firstBread) {
                    firstBread = i;
                    System.out.println("first" + firstBread);
                }
                lastBread = i;
                System.out.println("last" + lastBread);
            }
        }
        if (breadCount < 2) {
            return "";
        } else {
            return str.substring(firstBread+5, lastBread);
        }
    }
    public static void main(String[] args) {
        System.out.println(getSandwich("xxbreadbreadjambreadyy"));
    }
}
