import java.util.Scanner;

public class DungeonGame {
    //private Player player;
    private DungeonMap map;
    Scanner input = new Scanner(System.in);

    public void play(){
        Player player = new Player();
        boolean GameLoop = true;

        // greet the user and prompt them for their specified class
        //prompt user for class
        System.out.println("Select your class (W or T):");
        System.out.println("1. Warrior (W or w)");
        System.out.println("2. Thief (T or t)");
        String pclass = input.next();
        player.setPlayerClass(pclass);
        System.out.println(player.getPlayerClass());
        System.out.println(player.getHealth());
       /* while(GameLoop){
            // win condition
            if(player.getGold() >= 100){
                System.out.println("");
                GameLoop = false;
            }
        }*/
    }


}
