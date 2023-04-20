import java.util.ArrayList;

public class GameState {
    Board board;
    ArrayList<GameState> children;
    ArrayList<Position> moveHistory;
    int score;
    boolean minimizing;
    int lvl = 0 ;
    GameState(Board board)
    {
        this.board = board;
        children = new ArrayList<>();
        moveHistory = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }
    public ArrayList<GameState> getChildren() {
        return children;}


}
