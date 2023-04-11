import java.util.ArrayList;
import java.util.HashMap;

public class MiniMax {

    GameStateTree tree = new GameStateTree();
    int i = 0;
    public int minimax(Board node, int depth, boolean maximizingPlayer) {
        System.out.println("glebiny: "+depth);
        System.out.println("maximizing? "+maximizingPlayer);
        if (depth == 0 || node.getAvailableMoves().size() == 0) // || gameFinished
            return heuristic(node);
        if (maximizingPlayer)
        {
            //node.setPlayer1Turn(true);
            int value = Integer.MIN_VALUE;
            for(Board nodeChild : getChildren(node))
            {
                value = Math.max(value, minimax(nodeChild, depth-1, false));
            }
            return value;
        }
        else
        {
            System.out.println("minimini");
            node.setPlayer1Turn(false);
            System.out.println(node.isPlayer1Turn());
            int value = Integer.MAX_VALUE;
            for(Board nodeChild : getChildren(node))
            {
                value = Math.min(value, minimax(nodeChild, depth-1, true));
            }
            return value;
        }
    }

    public ArrayList<Board> getChildren(Board board)
    {
        ArrayList<Board> childrenBoard = new ArrayList<>();
        ArrayList<Position> moves = board.getAvailableMoves();
        int i =0;
        System.out.println(board.isPlayer1Turn());
        if(tree.getRoot() == null)
        {
            tree.addChild(null, board);
        }
        for(Position pos : moves)
        {
            System.out.println("dziecko nr: "+i);
            Board childBoard = board.clone();

            //overload equals
            childBoard.setDisk(pos);
            childrenBoard.add(childBoard);
           // System.out.println(pos);
           // childBoard.printBoard();
            tree.addChild(board, childBoard);
            i++;
        }
        return childrenBoard;
    }

    public int heuristic(Board node)
    {
        return 0;
    }

    public void print()
    {
        tree.printTree(tree.getRoot(), 0);
    }


}
