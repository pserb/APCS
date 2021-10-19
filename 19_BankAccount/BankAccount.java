/**
   Scrooge Playducks - Paul Serbanescu, Yuki Feng, Jaylen Zeng
   APCS Period 7
   HW19: Mo Money Mo Problems ...MORE AWESOME
   10/18/2021

   DISCO:
   If statements can evaluate multiple conditions: such as if x > 10 or x  < 5 by using the || operator
   if x > 10 and x < 5 uses the && operator
   
   QCC:
**/

public class BankAccount {

  //instance variables
  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;
  //---------------------------------------------


  //mutators
  public String setName( String newName ) {
    String oldName = name;
    name = newName;
    return oldName;
  }

  public String setPasswd( String newPasswd ) {
    String oldPasswd = passwd;
    passwd = newPasswd;
    return oldPasswd;
  }

  public short setPin( short newPin ) {
    if ((newPin < 1000) || (newPin > 9999)) {
      short oldPin = pin;
      pin = 9999;
      System.out.println("Invalid PIN Number. Not 4 Digits. Current PIN Number set to 9999");
      return oldPin;
    } else {
      short oldPin = pin;
      pin = newPin;
      return oldPin;
    }
  }



  public int setAcctNum( int newAcctNum ) {
    if ((newAcctNum < 100000000) || (newAcctNum > 999999999)) {
      int oldAcctNum = acctNum;
      acctNum = 999999999;
      System.out.println("Invalid Account Number. Not 9 Digits. Current Account Number set to 999999999");
      return oldAcctNum;
    } else {
	    int oldAcctNum = acctNum;
	    acctNum = newAcctNum;
	    return oldAcctNum;
    	}
    	
  }

  public double setBalance( double newBalance ) {
    double oldBalance = balance;
    balance = newBalance;
    return oldBalance;
  }
  //---------------------------------------------


  public void deposit( double depositAmount ) {
    balance = balance + depositAmount;
  }

  public void withdraw( double withdrawAmount ) {
    if (withdrawAmount > balance) {
      System.out.println("Cannot withdraw specified amount: Insuficient balance");
    } else {
      balance = balance - withdrawAmount;
    }
  }

  //---------------------------------------------

  public boolean authenticate(int checkAcctNum, String checkPasswd) {
    if ((checkAcctNum == acctNum) && (checkPasswd == passwd)) {
      return true;
    } return false;
  }


  //overwritten toString()
  public String toString() {
    String retStr = "\nAccount info:\n=======================";
    retStr = retStr + "\nName: " + name;
    retStr = retStr + "\nPassword: " + passwd;
    retStr = retStr + "\nPIN: " + pin;
    retStr = retStr + "\nAccount Number: " + acctNum;
    retStr = retStr + "\nBalance: " + balance;
    retStr = retStr + "\n=======================";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args ) {
    	BankAccount duck = new BankAccount();
    
	duck.setName("Scrooge");
	duck.setPasswd("moneymoney");
  // test pin
	duck.setPin((short)10);
	duck.setPin((short)1234);

  // test acctnum
	duck.setAcctNum(123);
	duck.setAcctNum(123456789);

	duck.setBalance(0);
  // check withdraw
	duck.deposit(520);
	duck.withdraw(600);
	
	System.out.println(duck.toString());

  // check authenticate
  System.out.println(duck.authenticate(123456789, "moneymoney"));
  System.out.println(duck.authenticate(123, "notpasswd"));

  }//end main()

}//end class BankAccount
