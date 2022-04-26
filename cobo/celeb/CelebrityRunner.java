/**
 * Starts the Celebrity Game application
 * @author cody.henrichsen
 *
 */
public class CelebrityRunner
{
	/**
	 * The entry point of the Java application.
	 * @param args Unused parameter as it is a GUI based program.
	 */
	public static void main(String [] args)
	{
		Celebrity Jimin = new Celebrity("Jimin", "BTS");
		System.out.println(Jimin.getClue());
		System.out.println(Jimin.getAnswer());
		Jimin.setClue("vocalist of BTS");
		Jimin.setAnswer("Jungkook");
		System.out.println(Jimin);
	}
}
