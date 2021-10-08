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
		
		BigSib richard = new BigSib();
		BigSib grizz = new BigSib();
		BigSib dotCom = new BigSib();
		BigSib tracy = new BigSib();

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