/*
The Bank should make and assign the account numbers to each user
How do we do this?
*/

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class BankAccount {

    public static List<Integer> allAccountNums = new ArrayList<>();
    private int accountNumber;

    private int pin;
    private double balance;

    public BankAccount() {
        for (;;) {
            // create a random 9-digit integer
            // IMPORTANT: all account numbers start with 1, and can not start with 0.
            accountNumber = 100000000 + new Random().nextInt(99999999);

            // check exisiting list of account numbers to see if newly created acc num is unique
            if (allAccountNums.contains(accountNumber)) {
                // if no more unique nums can be created
                // prevents infinite for(;;) from being... infinite
                if (allAccountNums.size() >= 199999999) {
                    System.out.println("Maximum number of accounts reached");
                    break;
                }
                // if not unique, resart loop and try again
                continue;
            } else {
                // if unique, add to list and end loop
                allAccountNums.add(accountNumber);
                break;
            }
        }
        this.balance = 0;
    }

    // overloaded const for creating acc with pin
    public BankAccount(int pin) {
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public String deposit(int pin, double amount) {
        // depositing requires the correct pin
        if (this.pin == pin) {
            this.balance += amount;
            return "Your current balance is " + balance;
        } return "Type the correct pin";
    }

    public String withdraw(int pin, double amount) {
        // withdrawing requires the correct pin
        if (this.pin == pin) {
            this.balance -= amount;
            return "Your current balance is " + balance;
        } return "Type the correct pin";
    }

    public static void main(String[] args) {
        // every new account holder is given a random account number
        // this account number can be accessed by the getAccountNumber() method
        BankAccount scrooge = new BankAccount();
        System.out.println(donald.getAccountNumber());

        // because the list is public and static, you can print out in main
        System.out.println(allAccountNums);

        // scrooge with a pin
        BankAccount scroogeWithPin = new BankAccount(4201);
        System.out.println(scroogeWithPin.getPin());

        System.out.println(scroogeWithPin.deposit(4201, 1000)); 
        System.out.println(scroogeWithPin.withdraw(4201, 500)); 
    }

}
