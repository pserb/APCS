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

public class BigSib {

	private String helloMsg;

	public BigSib() {
		helloMsg = "how it do";
	}

	public BigSib(String s) {
		helloMsg = s;
	}
	
	public String greet(String name) {
		return helloMsg + " " + name;
	}
}
