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

    public String toString() {
        return name + " with height " + height + " and season " + season;
    }
}