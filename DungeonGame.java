import java.util.Scanner;
public class DungeonGame {
    private DungeonMap map;
    private Player player = new Player();
    private Room[][] room;
    private Scanner scanner = new Scanner(System.in);;
    private String pClass;
    private int xPos = 0;
    private int yPos = 0;

    public DungeonGame() {
        boolean cont = true;
        while (cont) {
            boolean validClass = false;

            System.out.println("Welcome to the dungeon!! \n" +
                    "You are surrounded by bags of gold and healing elixirs, but beware the monsters.\n");

            while(!validClass) {


                System.out.println("Select your class");
                System.out.println("[1] Warrior");
                System.out.println("[2] Thief");
                pClass = scanner.nextLine();
                if(pClass.equals("1") || pClass.equals("2")){
                    validClass = true;
                }
            }
            player.setPlayerClass(pClass);
            System.out.println("Do you want the basic map dimensions? y/n ");
            Scanner scanner = new Scanner(System.in);
            String basicDimensions = scanner.nextLine();

            if (basicDimensions.equalsIgnoreCase("y")) {
                xPos = 10;
                yPos = 10;
                cont = false;
            } else if (basicDimensions.equalsIgnoreCase("n")) {

                while (xPos < 3) {
                    System.out.println("Enter X dimension that is greater than 3");
                    xPos = scanner.nextInt();
                }
                while (yPos < 3) {
                    System.out.println("Enter Y dimension that is greater than 3");
                    yPos = scanner.nextInt();
                }
                cont = false;
            }else {
                System.out.println("Input not recognized.");
            }
        }


        map  = new DungeonMap(player, yPos, xPos);

        map.setDungeonMap(xPos, yPos);

    }

    public void play() {
        boolean validClass = false;

        System.out.println("Welcome to the dungeon!! \n" +
                "You are surrounded by bags of gold and healing elixirs, but beware the monsters.\n");



        System.out.println("===================================================");

        boolean gameLoop = true;
        while (gameLoop) {
            //construct and print out updated map of the dungeon each turn
           
            map.print();
            System.out.println("HP: "+player.getHealth());
            System.out.println("Gold: "+player.getGold()+99);
        
            String userMove;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a door: [W] up, [S] down, [A] left, [D] right, [Q] exit ==>  ");
            userMove = scanner.next();

            if (userMove == "Q") {
                gameLoop = false;
                break;
            }
            else

            if(player.getGold() >= 100){
                System.out.println("You have found 100 gold pieces to escape the dungeon!");
                System.out.println("Congratulations you win!");
                gameLoop = false;
                break;
            }

            handleUserInput(userMove);

            if (!isPlayerAlive()) {
                System.out.println("You have died which means your adventure comes to an end.... until next time");
                break;
            }


            System.out.println("===================================================");


        }
    }


    private void handleUserInput(String userMove) {

        switch (userMove) {
            case "w":
                if (map.playerLocationValid(0, -1)) {
                    map.playerLocation(0, -1);
                }
                break;

            case "s":
                if (map.playerLocationValid(0, 1)) {
                    map.playerLocation(0, 1);
                }
                break;

            case "a":
                if (map.playerLocationValid(-1, 0)) {
                    map.playerLocation(-1, 0);
                }
                break;

            //fix directions so player move in correct direction
            case "d":
                if (map.playerLocationValid(1, 0)) {
                    map.playerLocation(1, 0);
                }
                break;


            default:
                System.out.println("Input choice not recognized.");
                break;
        }
       


    }

    private boolean isPlayerAlive() {
        return player.getHealth() > 0;
    }

    public String getpClass() {
        return pClass;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }
}
