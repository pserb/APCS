/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card a = new Card("Spades", "A", 1);
		Card b = new Card("Spades", "A", 1);
		Card c = new Card("Hearts", "3", 3);

		System.out.println(a.matches(b));
		System.out.println(b.matches(c));

		System.out.println(c);
	}
}
