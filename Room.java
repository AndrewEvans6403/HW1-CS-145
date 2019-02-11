import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Room {
    private boolean visited = false;

    private String mapIcon;


    public void enter(Player player) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int encounter = random.nextInt(2)+1;

        if (!visited) {

            System.out.println(encounter);
            // if encounter is monster
            if (encounter == 1) {

                Monster monster = new Monster();
                monster.initializeMonster();

                System.out.println("A " + monster.getMonsterType() + " appears");
                boolean monsterAlive = true;
                while (monsterAlive) {
                    System.out.println("Select an action: [1] Attack, [2] Run ");
                    String combatAction = scanner.nextLine();



                    //attack
                    if (combatAction.equals("1")) {
                        //monster attack
                        int playerLowerBound = 3;
                        monster.setDamage(ThreadLocalRandom.current().nextInt(1,monster.getDamage()+1));
                        monster.attack(player);
                        player.setDamage(ThreadLocalRandom.current().nextInt(playerLowerBound,player.getDamage()+1));
                        if(player.getDamage() == playerLowerBound) {
                            player.setDamage(ThreadLocalRandom.current().nextInt(playerLowerBound, player.getDamage()+1));
                        }
                        System.out.println("The " + monster.getMonsterType() + "hits you for " + monster.getDamage() + " damage!");

                        //player attack
                        player.attack(monster);
                        System.out.println("You attack and hit the " + monster.getMonsterType() + " for " + player.getDamage() + " damage");
                        if (monster.getHealth() <= 0) {
                            System.out.println("The " + monster.getMonsterType() + " dies!");
                            int randGold = ThreadLocalRandom.current().nextInt(5,30)+1;
                            player.onLoot(randGold);
                            System.out.println("You find " +randGold+" gold");
                            monsterAlive = false;
                        }
                    }

                    //run
                    else if (combatAction.equals("2")) {
                        monster.attack(player);
                        System.out.println("You try to run... ");
                        System.out.println("The " + monster.getMonsterType() + "attacks and hits you for " + monster.getDamage() + " damage as you try to escape");
                        break;

                    } else {
                        System.out.println("Invalid input");

                    }


                }
                visited = true;

            }

            // if encounter is loot
            else if (encounter == 2) {
                int goldOrHeal = random.nextInt(2)+1;

                // health encounter
                if (goldOrHeal == 1) {
                    int healthPotion = ThreadLocalRandom.current().nextInt(5,30)+1;
                    player.onHeal(healthPotion);
                    System.out.println("You found a health potion and gained " +healthPotion+" health");
                }

                // gold encounter
                if (goldOrHeal == 2) {
                    int goldLoot = ThreadLocalRandom.current().nextInt(5,40)+1;
                    player.onLoot(goldLoot);
                    System.out.println("You found a bag of gold and gained "+goldLoot+" gold");


                }
            }

        }
    }



    public String getMapIcon() {
        return mapIcon;
    }

    public void setMapIcon(String mapIcon) {
        this.mapIcon = mapIcon;
    }
}
