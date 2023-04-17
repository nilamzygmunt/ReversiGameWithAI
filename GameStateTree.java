import java.util.ArrayList;

public class GameStateTree {
//    private class Node {
//        Board board;
//        ArrayList<Node> children;
//        Node(Board board)
//        {
//            this.board = board;
//            children = new ArrayList<>();
//        }
//
//        public Board getBoard() {
//            return board;
//        }
//        public ArrayList<Node> getChildren() {
//            return children;
//        }
//    }
    Board root;
    public Board getRoot() {
        return root;
    }
   // Node root;
//    public Node getRoot() {
//         return root;
//    }
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
//   void addChild(Board parent, Board child)
//   {
//
//       if(parent == null) {
//           System.out.println("NULL");
//           root = new Node(child);
//           return;
//       }
//       Node parentNode = getNode(root, parent);
//
//       if(parentNode != null)
//       {
//           System.out.println("FOUND PARENT");
//           parentNode.getChildren().add(new Node(child));
//       }
//   }
   void addChild(Board parent, Board child)
    {

        if(parent == null) {
            System.out.println("NULL");
            root = child;
            return;
        }
        parent.children.add(child);
        //Node parentNode = getNode(root, parent);

    }
    void printTree(Board curr,int level)
    {
        curr.printState(level);
        if(curr.children.size()!=0)
        {
            level++;
            for(Board child : curr.children)
                printTree(child, level);
        }
    }
}
