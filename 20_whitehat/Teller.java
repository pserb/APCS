/*
   Scrooge Playducks - Paul Serbanescu, Yuki Feng, Jaylen Zeng
   APCS Period 7
   HW20: External Audit
   10/19/2021
   DISCO: When including a parameter for a method that returns short, you must include the phrase "(short)" before the value to convert the inputted int into a short
   QCC: Why must we include (short) when calling a method that returns a short value? Is this a special case, or are there other data types that do this?
*/

public class Teller {
    public static void main(String[] args) {
            BankAccount tom = new BankAccount(); //Initial method tests. Everything works fine so far... 
            tom.setName("tommy");
            tom.setPass("money");
            tom.setPIN((short) 1234);
            tom.setAccNum(123456789);
            tom.setBalance(5);

    //NOTE: Comments placed next to method calls that return unexpected results.
    tom.setPIN((short) 9999);
    tom.setPIN((short) 1000);
    tom.setPIN((short) 2416);
    tom.setPIN((short) 123);


    tom.setAccNum(100000000);
    tom.setAccNum(999999999);
    tom.setAccNum(641209841);
    tom.setAccNum(12498792);
    //tom.setAccNum(012345678); Returns error: "Integer number too large". This account number shouldn't work anyway according to the conditional statement, but it's something to think about.

    // should both not change balance and print error message saying unable to withdraw specified amount
    tom.withdraw(20); // Nothing is changed as expected because balance didn't have enough money. However, there is no error message.
    System.out.println(tom.toString()); // System.out.println(tom); does the same - toString method is overwritten from java's default (which would defautly print BankAccount@<randomdigits>)
    
    System.out.println(tom); // works as expected
    
    tom.setAccNum(123456789);
    // all of the following correct and test all possible cases
    System.out.println(tom.authenticate(123456789, "money")); 
    System.out.println(tom.authenticate(987654321, "moneymoney")); 
    System.out.println(tom.authenticate(578403286, "money")); 
    System.out.println(tom.authenticate(123456789, "moneymoney"));
    }
}
