import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private double lootModifier;

    Random random = new Random();

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
        // if user is thief class set attributes
        if(this.playerClass.equals("T") || this.playerClass.equals("t")){
            this.health = 70;
            this.damage = 10;
            this.lootModifier = .20;
        }
        // if user is warrior class set attributes
        else if(this.playerClass.equals("W") || this.playerClass.equals("w")){
            this.health = 100;
            this.damage = 15;
            this.lootModifier = 0;
        }


    }
    // accessor and mutator methods 
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {this.health = health;}
    public int getDamage() {
        return damage;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public double getLootModifier() {
        return lootModifier;
    }
    public void setLootModifier(double lootModifier) {
        this.lootModifier = lootModifier;
    }


    public void attack() {
        int minDamage = 5;
        int maxDamage = 26;
        // set random num between min and max range
        int randNum = ThreadLocalRandom.current().nextInt(minDamage,maxDamage);
    }

    public void onHit(int damage) {
        this.health -= damage;
    }

    public void onHeal(int health) {


        // if thief picks up potion and it exceeds players current max health update players health
        if (((this.playerClass.equals("T") || this.playerClass.equals("t")) && (this.health >= 70))) {
            this.health = 70;
        }
        // if warrior picks up potion and it exceeds players current max health update players health
        if (((this.playerClass.equals("W") || this.playerClass.equals("w")) && (this.health >= 100))) {
            this.health = 100;
        }
    }

    public void onLoot(int gold) {

    }

}
