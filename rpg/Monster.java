public class Monster {
    String name;
    int health;
    int damageDealt;

    public Monster() {
        health = 100;
    }

    public Monster(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return (health > 0);
    }

    public int attack(Protagonist p) {
        // attack protagonist
        // 2/3 chance the monster lands an attack
        // 0, 9 points of damage
        damageDealt = (int) (Math.random() * 10);

        // if protagonist uses specialize...
        if (p.doubleDmg) {
            // 1/3 chance the attack misses
            if (Math.random() > 0.7) {
                damageDealt = 0;
            }
            // System.out.println("BEFORE DOUBLE " + damageDealt);
            // System.out.println("THIS SHOULD BE TRUE: " + p.doubleDmg);
            damageDealt *= 2;
            // System.out.println("AFTER DOUBLE " + damageDealt);
            p.health -= damageDealt;
            return damageDealt;
        } else {
            // 1/3 chance the attack misses
            if (Math.random() > 0.7) {
                damageDealt = 0;
            }
            p.health -= damageDealt;
            return damageDealt;
        }
    }
}
