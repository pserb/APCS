/* 
IDK (Paul Serbanescu, May Qiu, Jeffery Tang)
APCS
L06 -- Reviews
2022-02-13
time spent: 4 hrs
*/

import java.io.*;
import java.util.*;

public class Act5 {

  public static ArrayList<String> restaurantRanker(String fileName) {
    // returns ArrayList of best -> worst restaurants

    ArrayList<String> negAdj = importList("negativeAdjectives.txt");
    ArrayList<String> posAdj = importList("positiveAdjectives.txt");

    String reviews = textToString(fileName);

    String[] splitReviews = reviews.split("-");

    ArrayList<Integer> values = new ArrayList<>();
    ArrayList<String> restaurantNames = new ArrayList<>();

    for (int i = 0; i < splitReviews.length; i++) {
      String[] temp = splitReviews[i].split(" ");
      restaurantNames.add(temp[0]);

      for (int j = 0; j < temp.length; j++) {
        temp[j] = removePunctuation(temp[j]);
      }
      // System.out.println(Arrays.toString(temp));

      int value = 0;
      for (String word : temp) {
        if (posAdj.indexOf(word) > -1) {
          value++;
        } else if (negAdj.indexOf(word) > -1) {
          value--;
        }
      }
      // System.out.println("Value for review " + i + ": " + value);
      values.add(value);
    }

    // System.out.println(values);
    // System.out.println(restaurantNames);

    ArrayList<String> orderedRestaruants = new ArrayList<>();

    for (int magic = 0; magic < splitReviews.length; magic++) {
      int largest = values.get(0);
      for (int i = 0; i < values.size(); i++) {
        if (values.get(i) > largest) {
          largest = values.get(i);
        }
      }

      int index = values.indexOf(largest);
      // System.out.println("Index: " + index);
      orderedRestaruants.add(restaurantNames.get(index));
      // System.out.println(orderedRestaruants);

      values.remove(index);
      restaurantNames.remove(restaurantNames.get(index));
    }

    return orderedRestaruants;
  }

  public static ArrayList<String> importList(String a) {
    ArrayList<String> list = new ArrayList<>();
    try {
      Scanner x = new Scanner(new File(a));
      while (x.hasNextLine()) {
        list.add(x.nextLine());
      }
      x.close();
    } catch (FileNotFoundException t) {
    }
    return list;
  }

  // from review
  public static String textToString(String fileName) {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      // add 'words' in the file to the string, separated by a single space
      while (input.hasNext()) {
        temp = temp + input.next() + " ";
      }
      input.close();

    } catch (Exception e) {
      System.out.println("Unable to locate " + fileName);
    }
    // make sure to remove any additional space that may have been added at the end
    // of the string.
    return temp.trim();
  }

  // from review
  public static String removePunctuation(String word) {
    while (word.length() > 0 && !Character.isAlphabetic(word.charAt(0))) {
      word = word.substring(1);
    }
    while (word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length() - 1))) {
      word = word.substring(0, word.length() - 1);
    }

    return word;
  }

  public static void main(String[] args) {
    System.out.println("Restaurants from best to worst: ");
    System.out.println(restaurantRanker("Reviews.txt"));
  }
}
