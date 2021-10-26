/***
 * NAMESPACE - Paul Serbanescu and Max Schneider
 * APCS
 * HW 24 - Get It While You Can
 * 2021-10-25
 * 0.4
 * 
 * DISCO:
 * Public instance variables become useful when wanting to compare the attributes of an object in a main method outside of its class
 * Working slow and methodical, only making small changes, and running code frequently. Not letting errors pile up
 * 
 * QCC:
 * Making the instance variables public feels kind of wrong. Is there a better way?
 * 
 * MODS:
 * Made upFace, name, flipCtr, headsCtr public
 * Made public int equalsCtr instance variable
 * Adjusted all constructors to implement this() and reset()
 * Adjusted reset to properly reset
 * Adjusted equals() to increment new instance var equalsCtr if this.upFace.equals(other.upFace), instaead of it just only returning a truth value
***/

public class Driver {

  public static void main( String[] args ) {

    // flip until x heads
    Coin first = new Coin("First Guy");
    int xHeads = 10;

    while (first.headsCtr < xHeads) {
      first.flip();
    }
    System.out.println("Coin " + first.name + " flipped " + first.flipCtr + " times before reaching " + xHeads + " heads");
    System.out.println();

    // flip until y matches
    Coin theRock = new Coin("The Rock");
    Coin kanye = new Coin("Kanye");
    int yMatches = 10;

    while (theRock.equalsCtr < yMatches) {
      theRock.flip();
      kanye.flip();
      theRock.equals(kanye);
    }
    System.out.println("Coins " + theRock.name + " and " +  kanye.name + " flipped " + theRock.flipCtr + " and " + kanye.flipCtr + " times (respectively) before reaching " + yMatches + " matches");
    System.out.println();

    // flip until at LEAST 65536 matches, and num of matches is divisible by year of birth (2005) 
    Coin redacted = new Coin("REDACTED");
    Coin confidential = new Coin("CONFIDENTIAL");
    
    while (redacted.equalsCtr < 65536 || redacted.equalsCtr % 2005 != 0) {
      redacted.flip();
      confidential.flip();
      redacted.equals(confidential);
    }
    System.out.println("Coins " + redacted.name + " and " +  confidential.name + " flipped " + redacted.flipCtr + " and " + confidential.flipCtr + " times (respectively) before reaching " + redacted.equalsCtr + " matches");


  }//end main()

}//end class
