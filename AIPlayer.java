import java.util.ArrayList;
import java.util.Random;

public class AIPlayer implements Player {
    private int playerId;
    ArrayList<Position> moves;

    public AIPlayer(int playerId)
    {
        this.playerId = playerId;
    }
    public int getPlayerId() {
        return playerId;
    }
    @Override
    public void getMoves(ArrayList<Position> moves) {
        this.moves = moves;
    }
    @Override
    public Position putDisk() {
        Random random_method = new Random();
        int index = random_method.nextInt(moves.size());
        return moves.get(index);
    }
}
