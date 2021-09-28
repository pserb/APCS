import java.util.Scanner;

public class CtoF {
    public static void main(String[] args) {
        System.out.println("---- Celsius to Fahrenheit Converter ----");
        Scanner usrObj = new Scanner(System.in);
        System.out.println("Enter degrees celsius: ");

        String cInput1 = usrObj.nextLine();
        usrObj.close();
        double cInput = Double.parseDouble(cInput1);

        double Fahrenheit = converter(cInput);
        System.out.println(Math.round(Fahrenheit * 10.0) / 10.0);
    }

    public static double converter(double celsius) {
        return celsius*(9.0/5.0) + 32;
    }
}
