public class Repeater {

	static String fenceW(int numPosts) {
		String result = "|";
		int count = 1;
		
		if (numPosts == 1) { return result; }
		while (count < numPosts) {
			result += "--|";
			count++;
		}
		return result;
	}
	
	static String fenceR(int numPosts) {
		String result = "|"; 
		if (numPosts == 1) {
			return result;
		}

		result = "|--" + fenceR(numPosts - 1);
		
		return result;
	}
	
	public static void main(String[] args) {
		//--------------------------------//
		System.out.println("--- Test While Loop ---");
		System.out.println(fenceW(1));
		System.out.println(fenceW(2));
		System.out.println(fenceW(3));
		
		//--------------------------------//
		System.out.println("--- Test Recursion ---");
		System.out.println(fenceR(1));
		System.out.println(fenceR(2));
		System.out.println(fenceR(3));
	}
}
