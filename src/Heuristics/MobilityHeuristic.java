package Heuristics;
import Game.*;
import java.util.ArrayList;

public class MobilityHeuristic implements Heuristic{

    @Override
    public int evaluate(GameState node, int player) {
        if(node.getBoard().isGameFinished())
            return node.getBoard().didThisPlayerWin(player) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        Board board = node.getBoard();
        //ArrayList<Game.Board> childrenBoard = new ArrayList<>();
        ArrayList<Position> moves = node.getBoard().getAvailableMoves();

        for(Position pos : moves)
        {
            Board childBoard = node.getBoard().clone();
            childBoard.setDisk(pos);
            GameState childGamestate = new GameState(childBoard);
            childGamestate.setMoveFromPreviousState(pos);

            childBoard.setPlayer1Turn(!childBoard.isPlayer1Turn());
            node.getChildren().add(childGamestate);
        }
        int allMoves =0;
        for(GameState child : node.getChildren())
        {
            allMoves += child.getBoard().getAvailableMoves().size();
        }
        if(node.getChildren().size() > 0) {
            return allMoves / node.getChildren().size()
                    + 100 * (!board.isPlayer1Turn() ? (board.getPlayer1DisksNumber() - board.getPlayer2DisksNumber())
                    : (board.getPlayer2DisksNumber() - board.getPlayer1DisksNumber()))
                    / (board.getPlayer1DisksNumber() + board.getPlayer2DisksNumber());
        }
        return node.getBoard().didThisPlayerWin(player) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
    }
}
