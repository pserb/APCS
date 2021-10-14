/* Paul Serbanescu
APCS

HW 14 - Customize Your Creation

DISCO:
	Default constructors provide general, default instructions for every instance. Further specificity of instruction can be applied to the instance by using an overloaded constructor.
	If you have multiple constructors, the overloaded one goes after the default one.

QCC:
	Is there a limit on the number of constructors?
	
2021-10-07
*/

public class Greet {
	public static void main(String[] args) {
		String greeting;
		
		BigSib richard = new BigSib("Word up");
		BigSib grizz = new BigSib("Hey ya");
		BigSib dotCom = new BigSib("Sup");
		BigSib tracy = new BigSib("Salutations");

		BigSib heyo = new BigSib(5);
		greeting = heyo.greet("you're an int");
		System.out.println(greeting);

		greeting = richard.greet("freshman");
		System.out.println(greeting);
		
		greeting = grizz.greet("Kong Fooey");
		System.out.println(greeting);
		
		greeting = dotCom.greet("mom");
		System.out.println(greeting);
		
		greeting = tracy.greet("Dr. Spaceman");
		System.out.println(greeting);
	}
}