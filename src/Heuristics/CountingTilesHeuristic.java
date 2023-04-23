package Heuristics;
import  Game.*;

public class CountingTilesHeuristic implements Heuristic {
    @Override
    public int evaluate(GameState node, int player) {
        if(node.getBoard().isGameFinished())
            return node.getBoard().didThisPlayerWin(player) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        Board board = node.getBoard();
        return 100 * (!board.isPlayer1Turn() ?  (board.getPlayer1DisksNumber() - board.getPlayer2DisksNumber())
                : (board.getPlayer2DisksNumber() - board.getPlayer1DisksNumber()))
                / (board.getPlayer1DisksNumber() + board.getPlayer2DisksNumber());

    }
}
