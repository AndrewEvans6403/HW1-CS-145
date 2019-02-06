public class DungeonMap {
  private String room[][] = {{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "},{" "," "," "," "," "}};//creates the map in a 2d array
    private Player player = new Player;// accesses player class to get the player class mainly

    public void DungeonMap(int rows, int columns){//sets the player's new location
      for (int y = 0; y < 5; y++){ //replaces the old player spot with a star to signal he has been there
            for (int x = 0; x < 5; x++ ){
                if(room[y][x] == player.getPlayerClass){
                   room[y][x] = "*";
                }
            }
        }
        room[rows][columns] = player.getPlayerClass;// sets the new player's location
    }

    public void print(){//prints out the dungeon board
        System.out.println("------------");
        for (int y = 0; y < 5; y++){
            System.out.print("|");
            for (int x = 0; x < 5; x++ ){
                System.out.print(room[y][x]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("------------");
    }
}



    public int xPos, yPos;
    public double userGold = 0;
    public int health = 0;
    public int damage = 0;
    public double goldMultiplier = 1;
    private static int ORC_DAMAGE = 6, ORC_INIT_HEALTH = 5, ORC_GOLD = 2;
    private String MAP_WALL = "*";
    private String MAP_FLOOR = " ";
    private String MAP_EXPLORED = "o";
    private String MAP_PLAYER = "P";
    public String dungeonMap[][];




    public static void main(String[] args) {

        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println("input maps width");
        int x = scanner.nextInt();
        System.out.println("input maps height");
        int y = scanner.nextInt();
        main.setDungeonMap(x, y);
        main.printDungeonMap();
//        String classType = main.setClass();
//        System.out.println(classType);


    }



    public String setClass() {

        boolean classSelect = true;
        String occupation = "";
        while (classSelect) {
            System.out.println("Select your class: (T)heif or (W)arrior");
            Scanner scanner = new Scanner(System.in);
            occupation = scanner.nextLine();
            if (occupation.equalsIgnoreCase("t")) {
                health = 70;
                damage = 10;
                goldMultiplier = 1.2;
                classSelect = false;
            } else if (occupation.equalsIgnoreCase("w")) {
                health = 100;
                damage = 15;
                goldMultiplier = 1;
                classSelect = false;
            } else {
                System.out.println("Class failed to select please try again.");
            }
        }
        return occupation;
    }

    public void setDungeonMap(int xPos, int yPos){
        dungeonMap = new String[yPos][xPos];
        for (int i = 0; i < yPos; i++){
            for (int j = 0; j < xPos; j++){
                if (j == 0 || j == xPos-1 || i == 0 || i == yPos-1){
                    dungeonMap[i][j] = MAP_WALL;
                } else{
                    dungeonMap[i][j] = MAP_FLOOR;
                }
            }
        }

    }

    public void printDungeonMap(){
        for (int i = 0; i < dungeonMap.length; i++){
            for (int j = 0; j < dungeonMap[i].length; j++){
                System.out.print(dungeonMap[i][j] + " ");
            }
            System.out.println();
        }
    }
