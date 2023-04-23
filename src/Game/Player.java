package Game;

import java.util.ArrayList;

public interface Player {
    Position putDisk(Board board);
    int getPlayerId();
    void setMoves(Board board);
    ArrayList<Position> getMoves();
    double getAvgTimes();
    double getAvgCount();

    void setDepth(int depth);
}
