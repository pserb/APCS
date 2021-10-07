/* HorseSoup - Paul Serbanescu and Xinqing Lin Incl. duckies Soup and Horse
APCS

HW 13 - Where do BigSibs come from?

DISCOVERIES:
	Constructors are ran automatically when a new instance of BigSib is created. You can provide parameters - such as a String, however
	this creates a small problem. Every instance of BigSib will have to have be provided that parameter when initialized otherwise java will throw an error
		BigSib(String s)

		BigSib bob = new BigSib("ello");  // "ello" MUST be there

	Using this knowledge, we can get rid of the setHelloMsg method alltogether, and pull the code that was inside it and put it in the implementation of public BigSib.

UNRESOLVED QUESTIONS:
	None

2021-10-06

*/

public class BigSib {

	private String helloMsg;

	public BigSib(String s) {   // constructor - runs automatically with every new BigSib instance (you can provide parameters like a String s)
		helloMsg = s;
	}
	
	public String greet(String name) {
		return helloMsg + " " + name;
	}
}
