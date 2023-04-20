import java.util.ArrayList;

public class GameStateTree {


    GameState root;
    public GameState getRoot() {
         return root;
    }

    public void setRoot(GameState node)
    {
        root = node;
    }
//    Node getNode(Node curr, Board board)
//    {
//        System.out.println("OG");
//        board.printState(0);
//        if(curr.board == board)
//            return curr;
//        for(Node child : root.getChildren())
//        {
//            System.out.println("BABY");
//            child.getBoard().printState(0);
//            if(child.getBoard() == board)
//            {
//                return child;
//            }
//            else getNode(child, board);
//        }
//        return null;
//    }
   void addChild(GameState parent, GameState child)
   {

       if(parent == null) {
           System.out.println("NULL");
           setRoot(child);
           return;
       }

       parent.getChildren().add(child);

   }
//   void addChild(Node parent, Node child)
//    {
//
//        if(parent == null) {
//            System.out.println("NULL");
//            root = child;
//            return;
//        }
//        parent.children.add(child);
//        //Node parentNode = getNode(root, parent);
//
//    }
    void printTree(GameState curr,int level)
    {
        for(int i = 0; i< level; i++) {
            System.out.print("\t");

        }
        System.out.print("score of board: "+curr.score+" ");
        System.out.print("min: "+curr.minimizing);
        System.out.println();
        curr.getBoard().printState(level);

        if(curr.children.size()!=0)
        {
            level++;
            for(GameState child : curr.getChildren())
                printTree(child, level);
        }
    }
}
