/*
Paul Serbanescu
HW29 - Which Way Do You Roll?
2021-11-2
0.5

DISCO:
Integer.toString(int) converts ints to strings.
Integer.parseint(String) convers Strings to ints.

QCC:
Is there a way to change the type of array the main method deals with?
Instead of (String[] args), can it be (int[] args) or (Object[] args)?
probably not, the main method is strictly defined, you can always just parseint String inputs if you wanted to
*/

public class Commafier {

    public static String commafyF(int input) {
        String strInput = Integer.toString(input);
        String output = "";

        for (int i = 0; i < strInput.length(); i++) {
            output += strInput.charAt(i);
            if (((strInput.length() - i) % 3 == 1) && (i != (strInput.length() - 1))) {
                output += ",";
            }
        }
        return output;
    }

    public static String commafyR(int input) {
        String strInput = Integer.toString(input);

        if (strInput.length() <= 3) {
            return strInput;
        }

        return commafyR(Integer.parseInt(strInput.substring(0, strInput.length() - 3))) + "," + strInput.substring(strInput.length() - 3);
    }

    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println("F " + commafyF(Integer.parseInt(arg)));
            System.out.println("R " + commafyR(Integer.parseInt(arg)));
        }
    }
}
