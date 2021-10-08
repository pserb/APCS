public class Greet {
	public static void main(String[] args) {
		String greeting;
		
		BigSib richard = new BigSib("Word up");
		greeting = richard.greet("freshman");
		System.out.println(greeting);
		
		BigSib grizz = new BigSib("Hey ya");
		greeting = grizz.greet("Kong Fooey");
		System.out.println(greeting);
		
		BigSib dotCom = new BigSib("Sup");
		greeting = dotCom.greet("mom");
		System.out.println(greeting);
		
		BigSib tracy = new BigSib("Salutations");
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);
	}
}

/* 
If BigSib constructor isn't given a string:

Greet.java:5: error: constructor BigSib in class BigSib cannot be applied to given types;
		BigSib richard = new BigSib();
		                 ^
  required: String
  found: no arguments
  reason: actual and formal argument lists differ in length
1 error

you MUST provide the constructor a string to compile
*/
