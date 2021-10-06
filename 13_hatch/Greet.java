/* NAMESPACE - Paul Serbanescu, Max, Orion - Incl. Duckies Soup, Versa, and Von Geburt
APCS

HW 13 - Where do BigSibs come from?

DISCOVERIES:
	BigSib now takes a parameter of type String. You must provide it one otherwise it will not compile.
	This parameter becomes the helloMsg and is combined with the name parameter in greet().

UNRESOLVED QUESTIONS:
	None

2021-10-04

*/

public class Greet {
	public static void main(String[] args) {
		BigSib god = new BigSib("Word up my man");
		System.out.println(god.greet("GOD"));

		BigSib kanye = new BigSib("Donda is the album of the century");
		System.out.println(kanye.greet("kanye"));
	}
}
