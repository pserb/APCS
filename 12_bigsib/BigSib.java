/* NAMESPACE - Paul Serbanescu, Max, Orion - Incl. Duckies Soup, Versa, and Von Geburt
APCS

HW 12 - On Elder Individuality and the Elimination of Radio Fuzz

DISCOVERIES:
	public class BigSib is a BLUEPRINT:
		Meaning it contains the instructions on how to create a BigSib

		In this example, it has 3 parts:
			String helloMsg
			setHelloMsg()
			greet()

			This means that every new BigSib (instance) will also have these three attributes to them:
				ex:
					BigSib JOHNCENA = new BigSib();
					-- You can set String helloMsg as you would any other variable (it is defined within class BigSib) -- 
					JOHNCENA.helloMsg = "AND HIS NAME IS";
					-- You can also call methods specific to JOHNCENA (which are constructed in BigSib) --
					JOHNCENA.setHelloMsg("AND HIS NAME IS");  // This calls JOHNCENA's setHelloMsg method
					JOHNCENA.greet("JOHNNNNNN CENA");  // This calls JOHNCENA's greet method

					All this to say that all of the above is specific only to JOHNCENA, and not to the class BigSib:
						BigSib never changes, the String helloMsg inside it doesnt change, the methods dont, etc. IT IS JUST A SET OF INSTRUCTIONS (BLUEPRINT)

		Okay, so how does setHelloMsg work?
			We pass in a String which is the hello message we want to be for the instance we are talking about (JOHNCENA's personal hello message)
			And so we write the method:
				public void setHelloMsg(String helloMsg) { // Why is it void?? - Well, all we want to do is SET JOHNCENA's hello message, and we don't need this to be returned back to us
					this.helloMsg = helloMsg;									 Think of it as just setting a variable. All this method does is set the helloMsg.
				} 
					// what is <this.>?? this. is being used here only because there is a namespace conflict with the global String helloMsg variable and the String helloMsg being
					   passed into the method. Because of this, we have to differentiate the two helloMsg (you cannot do helloMsg = helloMsg... why? well which helloMsg are you talking
					   about - the BigSib var, or the method var?)
					   How to differentiate the vairables: this. operator. Esentially, what this. does is that for the specific instance of BigSib which is called, this. gets changed
					   behind the scenes to the NAME of the instance. So, when we call JOHNCENA.setHelloMsg("AND HIS NAME IS"), the method sees this:

					   		public void setHelloMsg(String helloMsg){	(this isnt real runnable code just for visualization purposes)
									JOHNCENA.helloMsg = "AND HIS NAME IS";  // familiar? well, it was what we did earlier within Greet.java's main method where we set JOHNCENA's helloMsg directly
							   }											 the same principle there applies here, and so that is what this. does.

		Okay, so we setHelloMsg for the instance of BigSib, now we have to write the greet method:
			The greet method is far simpler - we want to pass a string which will serve as the name, and combine it with the helloMsg and print that from within main.
			This means that greet must have a return type of String:
				
				public String greet(String name) {
					return helloMsg + " " + name;     // this method is simple, we take the helloMsg that we just set in setHelloMsg, and we add it to the name that we get when greet() is called
				}									 // NOTE: we add a " ", otherwise the helloMsg would be connected with name
				

				
UNRESOLVED QUESTIONS:
	None

2021-10-04

*/

public class BigSib {

	String helloMsg;
	
	public void setHelloMsg(String helloMsg) {
		this.helloMsg = helloMsg;
	}
	
	public String greet(String name) {
		return helloMsg + " " + name;
	}
}
