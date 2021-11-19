public class Protagonist {
    String name;
    int health;
    int damageDealt;
    boolean doubleDmg;

    public Protagonist() {
        health = 100;
        // boolean doubleDmg = false;
    }

    public Protagonist(String name) {
        this();
        this.name = name;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public void specialize() {
        // If you land a hit, you incur greater damage,
        // ...but if you get hit, you take more damage.

        doubleDmg = true;

        // 3/5 chance specialize attack lands
        if (Math.random() > 0.4) {
            // special attack - 15, 29 points of damage
            damageDealt = (int) (Math.random() * 15) + 15;
        } else {
            damageDealt = 0;
        }
    }

    public void normalize() {
        // normal attack - 1, 10 points of damage
        doubleDmg = false;
        damageDealt = (int) (Math.random() * 10) + 1;
    }

    public int attack(Monster m) {
        // attack monster
        m.health -= damageDealt;
        return damageDealt;
    }

    public String getName() {
        return name;
    }
}
