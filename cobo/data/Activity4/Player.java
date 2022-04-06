// JIMIN :: Ryan Lau, Melody Lew, Paul Serbanescu
// APCS
// LAB08 -- America's Next Top Data Scientist
// 2022-04-05
// time spent: 2.5hrs + class time

public class Player {
    private String season;
    private String name;
    private double height;

    public Player() {
        season = null;
        name = null;
        height = 0;
    }

    public Player(String season, String name, double height) {
        this.season = season;
        this.name = name;
        this.height = height;
    }

    public String getSeason() {
        return this.season;
    }

    public double getHeight() {
        return this.height;
    }

    public String toString() {
        return name + " with a height of " + height + " cm";
    }
}