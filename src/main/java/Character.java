import java.util.List;
import java.util.Random;

public class Character {

    String name;
    int health;
    int strength;
    int luck;

    public Character(String name) {
        this.name = name;
        Random random = new Random();
        health = random.nextInt(100);
        strength = random.nextInt(100);
        luck = random.nextInt(100);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getLuck() {
        return luck;
    }
}
