import java.util.Scanner;
public class DungeonGame {
    private DungeonMap map = new DungeonMap();
    public Player player = new Player();
    private Room room;
    private Scanner scanner = new Scanner(System.in);;
    private String pClass;

    public DungeonGame() {
    }

    public void play() {
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

        boolean cont = true;
        while (cont) {
            System.out.println("Do you want the basic map dimensions? y/n ");
            Scanner scanner = new Scanner(System.in);
            String basicDimensions = scanner.nextLine();

            if (basicDimensions.equalsIgnoreCase("y")) {
                map.setDungeonMap(10, 10);
                cont = false;
            } else if (basicDimensions.equalsIgnoreCase("n")) {
                int x = 0;
                int y = 0;
                while (x < 3) {
                    System.out.println("Enter X dimension that is greater than 3");
                    x = scanner.nextInt();
                }
                while (y < 3) {
                    System.out.println("Enter Y dimension that is greater than 3");
                    y = scanner.nextInt();
                }
                map.setDungeonMap(x, y);
                cont = false;
            }else {
                System.out.println("Input not recognized.");
            }
        }
        System.out.println("===================================================");

        while (true) {
            //construct and print out updated map of the dungeon each turn

            map.print();


            Scanner scanner = new Scanner(System.in);
            System.out.println("Select a door: [W] up, [S] down, [A] left, [D] right, [q] exit ==>  ");
            String userMove = scanner.next();

            if (userMove == "q") {
                break;
            }

            handleUserInput(userMove);

            if (!isPlayerAlive()) {
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
                } else {
                    break;
                }
            case "s":
                if (map.playerLocationValid(0, 1)) {
                    map.playerLocation(0, 1);
                } else {
                    break;
                }
            case "a":
                if (map.playerLocationValid(1, 0)) {
                    map.playerLocation(1, 0);
                } else {
                    break;
                }
                //fix directions so player move in correct direction
            case "d":
                if (map.playerLocationValid(1, 0)) {
                    map.playerLocation(1, 0);
                } else {
                    break;
                }
            default:
                System.out.println("Input choice not recognized.");
                return;
        }

        room = new Room();
        room.enter(player);


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
