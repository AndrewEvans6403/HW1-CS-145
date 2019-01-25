public class DungeonMap {
  private String dungeonMap[][] = {{"*","*","*","*","*"},{"*","*","*","*","*"},{"*","*","*","*","*"},{"*","*","*","*","*"},{"*","*","*","*","*"}};

  
  public void dungeon(){
        System.out.println("------------");
        for (int y = 0; y < 5; y++){
            System.out.print("|");
            for (int x = 0; x < 5; x++ ){
                System.out.print(dungeonMap[y][x]);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        System.out.println("------------");
    }
}
