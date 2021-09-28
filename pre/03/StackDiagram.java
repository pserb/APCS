public class StackDiagram {
    public static void zoop() {
        baffle();
        System.out.print("You wugga ");
        baffle();
    }

    public static void main(String[] args) {
        System.out.print("No, I ");
        zoop();
        System.out.print("I ");
        baffle();
    }

    public static void baffle() {
        System.out.print("wug");
        ping();
    }

    public static void ping() {
        System.out.println(".");
    }
}

// Output is as follows:
// No, I wug.
// You wugga wug.
// I wug.

// zoop
// baffle
// ping
// main

// Invoking baffle(); at the end of ping results in an infinite
// feedback loop which prints 'wug' to the console forever