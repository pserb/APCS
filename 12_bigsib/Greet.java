/* NAMESPACE - Paul Serbanescu, Max, Orion - Incl. Duckies Soup, Versa, and Von Geburt
APCS

HW 12 - On Elder Individuality and the Elimination of Radio Fuzz

DISCOVERIES:
	

UNRESOLVED QUESTIONS:
	None

2021-10-04

*/

import java.util.*
public class Greet {
	public static void main(String[] args) {
		BigSib god = new BigSib();

		god.setHelloMsg("What's up my man ");
		System.out.println(god.greet("god"));
		
		/////////////////////////////////////
		
		BigSib batman = new BigSib();
		
		batman.setHelloMsg("YO ARE YOU REALLY ");
		System.out.println(batman.greet("BATMAN?"));
		
		
		List<String> namelist = Arrays.asList("first", "second", "kanye");
		
		namelist.forEach(name -> System.out.println("ello there, " + name));
		
	}
}
