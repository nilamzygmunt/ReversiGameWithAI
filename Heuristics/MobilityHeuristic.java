import java.util.ArrayList;

public class MobilityHeuristic implements Heuristic{

    @Override
    public int heuristic(GameState node) {
        Board board = node.getBoard();
        //ArrayList<Board> childrenBoard = new ArrayList<>();
        ArrayList<Position> moves = node.getBoard().getAvailableMoves();

        for(Position pos : moves)
        {
            Board childBoard = node.getBoard().clone();
            childBoard.setDisk(pos);
            GameState childGamestate = new GameState(childBoard);
            childGamestate.moveHistory.add(pos);

            childBoard.setPlayer1Turn(!childBoard.isPlayer1Turn());
            node.children.add(childGamestate);
        }
        int allMoves =0;
        for(GameState child : node.children)
        {
            allMoves += child.getBoard().getAvailableMoves().size();
        }
        if(node.getChildren().size() > 0)
            return allMoves/node.getChildren().size()
                    + 100 * (!board.isPlayer1Turn() ?  (board.getPlayer1DisksNumber() - board.getPlayer2DisksNumber())
                    : (board.getPlayer2DisksNumber() - board.getPlayer1DisksNumber()))
                    / (board.getPlayer1DisksNumber() + board.getPlayer2DisksNumber());
        else return node.getBoard().getPlayer2DisksNumber() >  node.getBoard().getPlayer1DisksNumber() ? Integer.MAX_VALUE : 0;
    }
}
