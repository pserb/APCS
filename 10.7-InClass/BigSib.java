public class BigSib {

	private String helloMsg;

	public BigSib(String s) {
		helloMsg = s;
	}
	
	public String greet(String name) {
		return helloMsg + " " + name;
	}
}
