/*
TNPG: pserb & Co (Andrew Piatesky, Paul Serbanescu, Joseph Othman) and Burnt Peanut
APCS
HW 38 -- Spin Class/Continue exploring random and practicing generating randum numbers/Filled in the skeleton called Slots.
2021-11-18
time spent: 1.5

DISCOVERIES:
The tested probability for a jackpot (rolling 3 lemons) is in agreement with the theoretical probability (1/6)^3 * 100%, or about 0.5% chance of winning
Splitting the code into smaller helper methods allows for cleaner code, which is easier to understand and implement

QUESTION:
How much money would I lose in Vegas?
*/

public class Slots {

    //instance variable to represent master copy for slot machine
    private static final String[] FRUITS = {
      "lime", "lime", "lime",
      "lemon", "lemon", "lemon",
      "cherry", "cherry", "cherry",
      "orange", "orange", "orange",
      "ugli", "ugli", "ugli",
      "peach", "peach", "peach"
    };
  
    private String[] _fruits; //to be init'd by each instance
  
  
    /*=====================================
      Slots() -- default constructor
      pre:  constant array FRUITS exists, has been initialized
      post: mutable array _fruits contains same elements as FRUITS
      =====================================*/
    public Slots() {
  
      //allocate memory for _fruits based on size of FRUITS:
      _fruits = new String[FRUITS.length];
  
  
      //copy elements of FRUITS into _fruits:
      int i = 0;
      for (String fruit : FRUITS) {
        _fruits[i] = fruit;
        i+=1;
      }
  
    } //end Slots
  
  
    /*=====================================
      String toString() -- overrides inherited toString()
      post: returns String of elements in slots 0 thru 2, separated by tabs
      =====================================*/
    public String toString() {
      String newStr = "";
  
      for (int i = 0; i < 3; i++) {
        newStr += _fruits[i] + "\t";
      }
  
      /* useful version of toString 
      newStr = "";
      for (int i = 0; i < _fruits.length; i+=3) {
        //System.out.println()
        newStr += _fruits[i] + " " + _fruits[i+1] + " " + _fruits[i+2] + "\n";
      }*/
  
      return newStr;
    } //end toString
  
  
    /*=====================================
      void swap(int,int) -- array swap util fxn
      pre:  _fruits array exists
      post: elements at indices i, j are swapped
      =====================================*/
    private void swap( int i, int j ) {
  
      //Stores index i because replaced in first line 
      String iIndex = _fruits[i];
  
      _fruits[i] = _fruits[j];
      _fruits[j] = iIndex;
  
    }
  
  
    /*=====================================
      void spinOnce() -- simulate a pull of the slot machine lever
      pre:  _fruits array exists
      post: randomized order of elements in _fruits array
      =====================================*/
    public void spinOnce() {
  
      int randNum;
  
      // A simple approach to shuffling:
      // iterate through the array, swapping
      // the val at each index with a randomly chosen other index
      for(int i = 0; i < _fruits.length; i++) {
        randNum = (int) (Math.random()*(_fruits.length));
        swap(i, randNum);
      }
    }
    
    
    /*=====================================
      boolean jackpot() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      false otherwise
      =====================================*/
    public boolean jackpot() {
      
      for (int i = 0; i < 3; i++) {
        if (!(_fruits[i].equals("lime"))) {
          return false;
        }
      }
      return true;
    }
    
    
    /*=====================================
      boolean miniWin() -- checks for a winning combo
      pre:  _fruits is existing array
      post: returns true if first 3 slots represent winning combo,
      or if first 3 slots mutually distinct,
      false otherwise
      =====================================*/
    public boolean miniWin() {
  
      if (jackpot() == true) {return true;}
  
      if ((!(_fruits[0].equals(_fruits[1]))) && (!(_fruits[1].equals(_fruits[2]))) && (!(_fruits[0].equals(_fruits[2])))) {
        return true;
      }
      return false;
    }
  
  
    //main() method for testing
    public static void main( String[] args ) {
      //usage: move bar below down 1 line at a time to test functionality...
  
  
      /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
      Slots machine01 = new Slots();
      /*
      System.out.println(machine01.toString());
      machine01.spinOnce();
      System.out.println(machine01.toString());
      System.out.println("==========");
      System.out.println(machine01.jackpot());
      System.out.println("==========");
      System.out.println(machine01.miniWin());
      System.out.println("==========");
      ===========================================================
      Methods to actually run fully functioning slot machine method*/
  
      Slots machine02 = new Slots();  
  
      //test to verify slot machines function indepently
      System.out.println();
      System.out.println( "Machine01 initial state:\t" + machine01 );
      System.out.println( "Machine02 initial state:\t" + machine02 );
  
      System.out.println( "\nSpinning machine01...\n" );
  
      machine01.spinOnce();
  
      System.out.println();
      System.out.println( "Machine01 state:\t" + machine01 );
      System.out.println( "Machine02 state:\t" + machine02 );
      System.out.println();
  
      // STATISTICS CODE
      int numMiniTries = 1;
      int numWinTries = 1;
      //test gamble-until-you-win mechanism
  
      System.out.println( "Preparing to spin until a mini win! . . ." );
      System.out.println( "------------------------------------" );
  
      //if you haven't won, spin again until you win!
      while( machine01.miniWin() == false ) {
        System.out.println( "Your spin..." + "\t" + machine01 );
        System.out.println( "LOSE\n" );
        numMiniTries += 1;
        machine01.spinOnce();
      }
  
      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "WIN\n" );
  
  
      System.out.println( "Preparing to spin until...jackpot! . . ." );
      System.out.println( "------------------------------------" );
  
      //if you haven't won, spin again until you win!
      while( machine01.jackpot() == false ) {
        System.out.println( "Your spin..." + "\t" + machine01 );
        System.out.println( "LOSE\n" );
        machine01.spinOnce();
        numWinTries += 1;
      }
  
      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "JACKPOT!\n" );
      System.out.println( "Your chance of winning was" + " " + (Math.round(((1.0/numWinTries)*100)*1000))/1000.0 + "%");
      System.out.println( "On the other hand it took " + (numMiniTries) + " to get a mini win!" );
      
  
  
    }//end main
  
  }//end class Slots
  