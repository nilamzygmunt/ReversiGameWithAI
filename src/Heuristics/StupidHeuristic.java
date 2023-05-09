package Heuristics;
import  Game.*;

public class StupidHeuristic implements Heuristic{
    @Override
    public int evaluate(GameState node, int player) {
        return MiniMax.rand.nextInt(0,99);

    }
}
