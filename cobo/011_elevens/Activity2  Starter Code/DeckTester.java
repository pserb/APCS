/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"A", "B", "C"};
		String[] suits = {"Graff", "Lions"};
		int[] values = {2, 1, 6};

		Deck dack = new Deck(ranks, suits, values);

		System.out.println(dack);
		dack.deal();
		System.out.println(dack);
	}
}
