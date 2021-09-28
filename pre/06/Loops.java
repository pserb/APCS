public class Loops {
    public static double power(double x, double n) {
        double ans = 1;
        for (int i=1; i<=n; i++) {
            ans *= x;
        } return ans;
    }
    public static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        } return ans;
    }
    public static double myexp(double x, int n) {
        double term = 1;
        double ans = 1;
        for (int i = 1; i < n; i++) {
            term *= x/i;
            ans += term;
        } return ans;
    }
    public static void check(double x) {
        System.out.println(x + "\t" + myexp(x, 19) + "\t" + Math.exp(x));
    }
    public static void main(String[] args) {
        System.out.println(power(10, 2));
        System.out.println();
        System.out.println(factorial(3));
        System.out.println();
        check(1);
        System.out.println();

        // As the absoulte value of x increases, the accuracy of myexp decreases
        for (double i = 0.1; i <= 100.0; i*=10) {
            check(i);
        } System.out.println();
        for (double i = -0.1; i >= -100.0; i*=10) {
            check(i);
        } System.out.println();
    }
}

