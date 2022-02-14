import java.io.*;
import java.util.*;

public class Act5 {

  public static String restaurantRanker(String fileName) {
    String[] negAdj = importList("negativeAdjectives.txt", 29);
    String[] posAdj = importList("positiveAdjectives.txt", 29);
    String[] ans = new String[7];
    String[][] temp2 = new String[7][];
    String reviews = textToString(fileName);
    String[][] words = new String[7][];
    String[] temp = reviews.split("-");
    String[] d = {" ", " "};
    for (int i=0 ; i < 7; i++) {
      words[i] = (temp[i]).split(" ");
      }
      System.out.println(words[1][0]);
    for (int x=0; x <temp2.length;x++){
      temp2[x]= d;
    }
    System.out.println(Arrays.toString(words));
    for(int x = 0; x < words.length; x++) {
      // System.out.println(x);
      int y = x;
      // System.out.println(words[x][0]);
      temp2[y][0] = words[x][0];
      System.out.println(temp2[0][0]);
    }
    System.out.println("yes");
    System.out.println(temp2[0][0]);
    for(int i = 0; i < words.length; i++) {
      System.out.println(temp2[0][0]);
      int counter =0;
      for(int j = 0; j < words[i].length; j++) {
        if(helper(words[i][j], posAdj)) {
          counter++;
        }
        else if(helper(words[i][j], negAdj)) {
          counter--;
        }
      }
      temp2[i][1] = "" + counter;
      System.out.println(temp2[0][0]);
      }
      for(int x=0;x<temp2.length;x++) {
        int largest = 0;
        for(int i=0;i<temp2.length;i++) {
          System.out.println(temp2[0][0]);
          if (Integer.parseInt(temp2[i][1]) > Integer.parseInt(temp2[largest][1])) {
            largest = i;
          }
          // System.out.println(temp2[i][0]);
          // System.out.println(Integer.parseInt(temp2[largest][1]));
        }
        ans[x]=temp2[largest][0];
        temp2[largest][1]="-359";
      }
    return Arrays.toString(ans);
  }

  public static boolean helper(String a, String[] b) {
    for(int i = 0; i < b.length ; i++) {
      if(a.equals(b[i])){
        return true;
      }
    }
    return false;
  }
  public static String[] importList(String a, int b){
    int counter = 0;
    String[] list = new String[b];
    try{
    Scanner x = new Scanner(new File(a));
    while(x.hasNextLine()){
      list[counter] = x.nextLine();
      counter++;
    }
    x.close();
  }catch(FileNotFoundException t){
  }
  return list;
}
public static String textToString( String fileName )
{
  String temp = "";
  try {
    Scanner input = new Scanner(new File(fileName));

    //add 'words' in the file to the string, separated by a single space
    while(input.hasNext()){
      temp = temp + input.next() + " ";
    }
    input.close();

  }
  catch(Exception e){
    System.out.println("Unable to locate " + fileName);
  }
  //make sure to remove any additional space that may have been added at the end of the string.
  return temp.trim();
}
  public static void main(String[] args) {
    System.out.println(restaurantRanker("Reviews.txt"));
  }
}
