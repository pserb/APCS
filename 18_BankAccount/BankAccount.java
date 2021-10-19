/* 
Scrooge Playducks - Paul Serbanescu, Yuki Feng, Jaylen Zeng

DISCO:
Using float datatype for a bank balance does not work: when trying to set
a float to 102.34 for example, java says "icompatible types: possible lossy conversion from double to float"

Because we want deposit and withdraw to return a confirmation that it worked, when doing duck.deposit or duck.withdraw, it must be inside a println statement, otherwise our return will not print

It's nice outside. "It's like... very sunny" - Yuki

QCC:
Why does float not work???

Q2: We know that Java must provide a default constructor because we have not defined one, and yet Java does not scream error at us.

Q3: A test to see whether Java provides a string representation would be to try System.out.println(instance) or System.out.println(ClassName)
*/

public class BankAccount {
	
	private String name;
	private String password;
	private int pin;
	private int accNum;
	private double balance;
	
	public void setName(String usrname) {
		name = usrname;
	}
	
	public void setPassword(String usrpassword) {
		password = usrpassword;
	}
	
	public void setPin(int usrpin) {
		pin = usrpin;
	}
	
	public void setAccNum(int usraccnum) {
		accNum = usraccnum;
	}
	
	public void setBalance(double usrbalance) {
		balance = usrbalance;
	}
	
	public String deposit(double deposit) {
		balance = balance + deposit;
		return "Your new balance is " + balance;
	}
	
	public String withdraw(double withdraw) {
		balance = balance - withdraw;
		return "Your new balance is " + balance;
	}
	
	public String getAccInfo() {
		return "Hello " + name + ", Account Number: " + accNum + ", Password: " + password + ", 4-digit PIN: " + pin + ", Current Balance: " + balance + " dollars."; 
	}
	
	public static void main(String[] args) {
		BankAccount duck = new BankAccount();
		
		duck.setName("Scrooge");
		duck.setPassword("moneymoney");
		duck.setPin(2418);
		duck.setAccNum(123456789);
		duck.setBalance(0);
		duck.deposit(520);
		duck.withdraw(100);
		
		System.out.println(duck.getAccInfo());
	}
}
