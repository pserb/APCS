/* NAMESPACE - Paul Serbanescu, Max, Orion - Incl. Duckies Soup, Versa, and Von Geburt
APCS

HW 10 - Refactor Big Sib One

DISCOVERIES:
	Methods can return Strings (or any type) to be printed in the main method.
	In this case - calling BigSib.greet("name") asks for a string in return, so in the simplest sense,
	calling BigSib.greet("name") == "some new string with name". As you do with any string in Java, you must
	System.out.println it.

UNRESOLVED QUESTIONS:
	None

2021-10-04

*/

public class Greet {
	public static void main(String[] args) {
		System.out.println(BigSib.greet("Lucky"));
		System.out.println(BigSib.greet("Ducky"));
		System.out.println(BigSib.greet("Funny"));
	}
}
