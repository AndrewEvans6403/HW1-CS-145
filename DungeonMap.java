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
