import java.util.Random;

public class IdiotHeuristic implements Heuristic{
    @Override
    public int heuristic(GameState node) {
        //Random rnd = new Random();
        return MiniMax.rand.nextInt(0,99);

    }
}
