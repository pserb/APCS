/* Paul Serbanescu
APCS

HW 08 - Refactor Freshie Zero -> Methods

2021-09-30

Discoveries:
	void greet(String) throws an error for multiple reasons:
		1. you must add static to void greet - java is unable to make a static refrences (main is static) to non static methods.
		
		2. java always wants you to specify variable types such as (String, int, boolean, double, float) - therefore greet(String) throws an error - something like greet(String s)
			will set "s" as a String variable and fix the error

	Two ways to do this:
		static void greet(String s) {
			System.out.println(s);
		}
		public static void main(String[] args) {
			greet("your string here"); - this emulates how print() works in python
		}

		-- ALTERNATIVELY --

		static void greet() {
		 	System.out.println("string1");
		 	System.out.println("string2");
			System.out.println("string3");
		}
		public static void main(String[] args) {
			greet();
		}

		==>	BENEFITS -- only one methond call in main which greatly declutters main and moves all repetative/not extremely vital
						code to methods. makes it much easier to find and edit these three strings (or add however many you want)
*/

public class Greet {
	static void greet(String s) {
		System.out.println(s);
	}
	static void alternateGreet() {
		System.out.println("Hello there Obi-Wan Kenobi");
		System.out.println("Good day Donald, Duck");
		System.out.println("How it do Mr. Moo?");
	}

	public static void main(String[] args) {
		greet("Duck,");
		greet("Duck...");
		greet("GOOSE!");

		System.out.println();

		alternateGreet();
	}
}
