/* NAMESPACE - Paul Serbanescu, Max, Orion - Incl. Duckies Soup, Versa, and Von Geburt
APCS

HW 10 - Refactor Big Sib One

DISCOVERIES:
	Previously here we had static void greet(String s) {}, but now we have replaced <void> with <String>.
	What void meant before was that the method did not return anything - in our case, it ran and just printed lines.
	What String means now is that the method MUST and DOES return a value type String. If this method does not return anything or
	returns something that is not a string, it will not compile.
	Return statements in Java are similar to python: they will terminate the method once called (any code after a return is unreachable)	

UNRESOLVED QUESTIONS:
	None

2021-10-04

*/

public class BigSib {
	static String greet(String s) {
		return "What it do " + s + "-do?";
	}
}
