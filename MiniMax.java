import java.util.ArrayList;
import java.util.HashMap;

public class MiniMax {

    GameStateTree tree = new GameStateTree();
    int i = 0;
    public int minimax(Board node, int depth, boolean maximizingPlayer) {
        if (depth == 0 || node.getAvailableMoves().size() == 0) // || gameFinished
            return (int)heuristic(node);
        if (maximizingPlayer)
        {
            node.setPlayer1Turn(true);
            int value = Integer.MIN_VALUE;
            i++;
            for(Board nodeChild : getChildren(node))
            {
                //System.out.println("DEPTH " + (depth));
                value = Math.max(value, minimax(nodeChild, depth-1, false));

            }
            System.out.println("`d: `"+depth+" h "+ value);

            return value;
        }
        else
        {
            System.out.println("minimini");
            i++;
            node.setPlayer1Turn(false);
            System.out.println(node.isPlayer1Turn());
            int value = Integer.MAX_VALUE;
            for(Board nodeChild : getChildren(node))
            {
                System.out.println("DEPTH " + (depth-1));
                value = Math.min(value, minimax(nodeChild, depth-1, true));
            }
            return value;
        }
    }

    public ArrayList<Board> getChildren(Board board)
    {
        ArrayList<Board> childrenBoard = new ArrayList<>();
        ArrayList<Position> moves = board.getAvailableMoves();
        //int i =0;
        //System.out.println("level of depth: "+i);
        if(tree.getRoot() == null)
        {
            tree.addChild(null, board);
        }
        for(Position pos : moves)
        {
            Board childBoard = board.clone();

            //overload equals
            childBoard.setDisk(pos);
            childrenBoard.add(childBoard);
            //System.out.println("child for the pos " +pos);
            //childBoard.printState(i);
            //childBoard.printBoard();
            tree.addChild(board, childBoard);

        }
        return childrenBoard;
    }

    public double heuristic(Board node)
    {
        node.printState(0);
        System.out.println((100*(node.getPlayer1DisksNumber() - node.getPlayer2DisksNumber())) /(node.getPlayer1DisksNumber() + node.getPlayer2DisksNumber()));
        return (100*(node.getPlayer1DisksNumber() - node.getPlayer2DisksNumber())) /(node.getPlayer1DisksNumber() + node.getPlayer2DisksNumber());
    }

    public void print()
    {
        //tree.printTree(tree.getRoot(), 0);
    }


}
