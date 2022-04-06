package Activity4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Activity4.Player;

public class Activity4 {
    public static void main(String[] args) {
        ArrayList<Player> allPlayers = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("all_seasons.csv"));

            while (input.hasNextLine()) {
                String[] temp = input.nextLine().split(",");

                String playerSeason = temp[temp.length-1];
                String playerName = temp[1];
                double playerHeight = Double.parseDouble(temp[4]);

                allPlayers.add(new Player(playerSeason, playerName, playerHeight));
            }  
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find all_seasons.csv");
        } 
    }
}
