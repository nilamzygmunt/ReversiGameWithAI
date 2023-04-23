package Game;
import Heuristics.*;
import java.util.ArrayList;
import java.util.List;

public class AIPlayer implements Player {
    private int playerId;

    public ArrayList<Position> getMoves() {
        return moves;
    }

    ArrayList<Position> moves = new ArrayList<>();
    Heuristic heuristic;
    ArrayList<Long> times = new ArrayList<>();
    ArrayList<Integer>  counterEvaluation = new ArrayList<>();
    private MiniMax miniMax;
    private boolean alphaBeta;
    private int depth= 3;
    public AIPlayer(int playerId, Heuristic heuristic, boolean alphaBeta)
    {
        this.playerId = playerId;
        this.heuristic = heuristic;
        this.alphaBeta = alphaBeta;
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
        miniMax = new MiniMax(depth, playerId);
        long start = System.currentTimeMillis();
        Position p = miniMax.findBestMove(board, heuristic, alphaBeta);
        long end = System.currentTimeMillis() - start;
        times.add(end);
        counterEvaluation.add(miniMax.getEvaluationCounter());
        return p;
    }
    @Override
    public double getAvgCount()
    {
        double avg = calculateAverageCount(counterEvaluation);
        counterEvaluation.clear();
        return avg;
    }
    @Override
    public double getAvgTimes()
    {
        double avg = calculateAverageTimes(times);
        times.clear();
        return avg;
    };

    public void setDepth(int depth)
    {
        this.depth = depth;
    }

    private double calculateAverageTimes(List<Long> marks) {
        return  marks.stream()
                .mapToLong(d -> d)
                .average()
                .orElse(0.0);
    }

    private double calculateAverageCount(List<Integer> marks) {
        return  marks.stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0.0);
    }
}
