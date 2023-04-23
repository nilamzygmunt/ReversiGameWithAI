import Game.AIPlayer;
import Game.Player;
import Game.ReversiGame;
import Heuristics.Heuristic;

import java.util.ArrayList;

public class Tester {
    Player player1;
    Player player2;

    public Tester(Heuristic player1Heuristic, Heuristic player2Heuristic, boolean alphaBeta)
    {
        player1 = new AIPlayer(1, player1Heuristic, alphaBeta);
        player2 = new AIPlayer(2, player2Heuristic, alphaBeta);
    }

    public void testStrengthMultipleGames(int numberOfGames, int depth)
    {
        player1.setDepth(depth);
        player2.setDepth(depth);
        for(int i =0;i< numberOfGames; i++)
        {
            ReversiGame reversi = new ReversiGame(player1, player2, 8, 8);
            reversi.ReversiGameDraft();
            System.out.println(reversi.didPlayer1Won());
        }
    }

    public void testPerformanceMultipleGames(int numberOfGames, int depth)
    {

        player1.setDepth(depth);
        player2.setDepth(depth);
        ArrayList<Double> times = new ArrayList<>();
        ArrayList<Double> counter = new ArrayList<>();
        for(int i =0; i< numberOfGames; i++)
        {
            ReversiGame reversi = new ReversiGame(player1, player2, 8, 8);
            reversi.ReversiGameDraft();
            times.add(reversi.getAverageTimeOfPlayer(0));
            counter.add(reversi.getAverageCountOfPlayer(0));
        }
        System.out.println("AVG time");
        for(Double avg : times)
            System.out.println(avg);
        System.out.println();
        System.out.println("AVG count");
        for (Double avg : counter)
            System.out.println(avg);
    }
}
