import java.util.ArrayList;

public class GameStateTree {
    private class Node {
        Board board;
        ArrayList<Node> children;
        Node(Board board)
        {
            this.board = board;
            children = new ArrayList<>();
        }

        public Board getBoard() {
            return board;
        }
        public ArrayList<Node> getChildren() {
            return children;
        }
    }

    Node root;
    public Node getRoot() {
         return root;
    }
    Node getNode(Node root, Board board)
    {
        if(root.board == board)
            return root;
        for(Node child : root.getChildren())
        {
            if(child.getBoard() == board)
            {
                return child;
            }
            else getNode(child, board);
        }
        return null;
    }
    void addChild(Board parent, Board child)
    {
        if(parent == null) {
            root = new Node(child);
            return;
        }
        Node parentNode = getNode(root, parent);
        if(parentNode != null)
        {
            parentNode.getChildren().add(new Node(child));
        }
    }
    void printTree(Node node, int level)
    {
        node.board.printState(level);
        if(node.getChildren().size()!=0)
        {
            level++;
            for(Node child : node.getChildren())
                printTree(child, level);
        }
    }
}
