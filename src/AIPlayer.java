import java.util.ArrayList;
import java.util.List;

public class AIPlayer implements Player {
    private int playerId;

    public ArrayList<Position> getMoves() {
        return moves;
    }

    ArrayList<Position> moves;
    Heuristic heuristic;
    ArrayList<Long> times = new ArrayList<>();
    private MiniMax miniMax;
    private boolean alphaBeta;

    public AIPlayer(int playerId, Heuristic heuristic, boolean alphaBeta)
    {
        this.playerId = playerId;
        this.heuristic = heuristic;
    }
    public int getPlayerId() {
        return playerId;
    }
    @Override
    public void setMoves(Board board) {
        moves = board.getAvailableMoves();
    }
    @Override
    public Position putDisk(Board board) {
        miniMax = new MiniMax();
        long start = System.currentTimeMillis();
        Position p = miniMax.findBestMove(board, heuristic, alphaBeta);
        long end = System.currentTimeMillis() - start;
        times.add(end);
        return p;
    }
    @Override
    public double getAvgTimes()
    {
        double avg = calculateAverage(times);
        times.clear();
        return avg;
    };

    private double calculateAverage(List<Long> marks) {
        return  marks.stream()
                .mapToLong(d -> d)
                .average()
                .orElse(0.0);
    }
}
