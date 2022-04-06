// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS
// LAB08 -- America's Next Top Data Scientist
// 2022-04-05
// time spent: 2.5hrs + class time

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {
        ArrayList<Player> allPlayers = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("all_seasons.csv"));
            input.nextLine(); // skip the first line/csv header
            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");

                String playerSeason = temp[temp.length-1];
                String playerName = temp[1];
                double playerHeight = Double.parseDouble(temp[4]);

                allPlayers.add(new Player(playerSeason, playerName, playerHeight));
            }
            input.close();
        } catch (Exception e) {
            System.out.println("Cannot find all_seasons.csv");
        }

        Player tallest = allPlayers.get(0);
        Player shortest = allPlayers.get(0);


        for (Player player : allPlayers) {
            if (player.getSeason().equals("2020-21")) {
                if (player.getHeight() > tallest.getHeight()) 
                    tallest = player;
                if (player.getHeight() < shortest.getHeight())
                    shortest = player;
            }
        }

        System.out.println("the tallest player in the 2020-21 season is: " + tallest);
        System.out.println("the shortest player in the 2020-21 season is: " + shortest);
        System.out.println("the height difference is: " + (tallest.getHeight() - shortest.getHeight()) + " cm");
    }
}
