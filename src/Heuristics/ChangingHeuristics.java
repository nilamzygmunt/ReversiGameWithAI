package Heuristics;

import Game.Board;
import Game.GameState;

public class ChangingHeuristics implements Heuristic{
    @Override
    public int evaluate(GameState node, int player) {
        if(node.getBoard().isGameFinished())
            return node.getBoard().didThisPlayerWin(player) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        double sumOfTiles = node.getBoard().getPlayer1DisksNumber() + node.getBoard().getPlayer2DisksNumber();
        double  allTiles = node.getBoard().getHeight() * node.getBoard().getWidth();
        double boardFilled = sumOfTiles / allTiles;
        Heuristic heuristic;
       // System.out.println(boardFilled);
        if(boardFilled < 0.3) {
            heuristic = new MobilityHeuristic();
            //System.out.println("Mobility");

        }
        else if(boardFilled > 0.3 && boardFilled < 0.8) {
            heuristic = new CornerHeuristic();
            //System.out.println("Corner");
        }
        else{
            heuristic = new CountingTilesHeuristic();
            //System.out.println("Counting");
        }

        return heuristic.evaluate(node, player);

    }
}
