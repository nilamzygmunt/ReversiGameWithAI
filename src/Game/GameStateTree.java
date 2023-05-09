package Game;

public class GameStateTree {


    GameState root;
    public GameState getRoot() {
         return root;
    }
    public BoardPrinter boardPrinter = new BoardPrinter();

    public void setRoot(GameState node)
    {
        root = node;
    }

   void addChild(GameState parent, GameState child)
   {

       if(parent == null) {
           setRoot(child);
           return;
       }

       parent.getChildren().add(child);

   }
    void printTree(GameState curr,int level)
    {
        for(int i = 0; i< level; i++) {
            System.out.print("\t");

        }
        System.out.println();
        boardPrinter.printState(curr.getBoard(), level);

        if(curr.getChildren().size()!=0)
        {
            level++;
            for(GameState child : curr.getChildren())
                printTree(child, level);
        }
    }
}
