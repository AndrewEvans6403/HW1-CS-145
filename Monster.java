import java.util.Random;

public class Monster {
    //initialize monster
    private int health;
    private int damage;
    private String monsterType;

    //Initializes monster
    public void initializeMonster(){
        Random random = new Random();
        int monster = random.nextInt(4);
        if (monster == 0){
            monsterType = "Goblin";
            health = 6;
            damage = 10;
        }else if (monster == 1){
            monsterType = "Zombie";
            health = 12;
            damage = 15;
        }else if (monster == 2){
            monsterType = "Orc";
            health = 18;
            damage = 20;
        }else if (monster == 3){
            monsterType = "Deneke";
            health = 55;
            damage = 5;
        }
    }
    // deals damage to player
    public void attack(Player target){
        target.onHit(damage);
    }
    // takes damage from player
    public void onHit(int damage){
        health -= damage;
    }
    //retruns monster's health
    public int getHealth(){
        return health;
    }
}

