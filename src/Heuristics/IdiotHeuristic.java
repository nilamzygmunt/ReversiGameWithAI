package Heuristics;
import  Game.*;
import java.util.Random;

public class IdiotHeuristic implements Heuristic{
    @Override
    public int evaluate(GameState node, int player) {
        //Random rnd = new Random();
        return MiniMax.rand.nextInt(0,99);

    }
}
