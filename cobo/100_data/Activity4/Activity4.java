import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Activity4 {
    public static void main(String[] args) {

        ArrayList<Player> allPlayers = new ArrayList<>();

        try {
            Scanner input = new Scanner(new File("../all_seasons.csv"));

            input.nextLine();
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

        System.out.println(allPlayers.get(1));

        for(Player player : allPlayers) {
            if (!player.getSeason().equals("2020-21")) {
                allPlayers.remove(player);
            } 
        }
    }
}