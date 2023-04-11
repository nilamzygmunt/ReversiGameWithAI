import java.util.ArrayList;

public interface Player {
    Position putDisk();
    int getPlayerId();
    void getMoves(ArrayList<Position> moves);
}
