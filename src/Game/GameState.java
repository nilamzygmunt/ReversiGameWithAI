package Game;

import java.util.ArrayList;

public class GameState {
    private Board board;
    private ArrayList<GameState> children;

    private Position moveFromPreviousState;
    int score;
    public GameState(Board board)
    {
        this.board = board;
        children = new ArrayList<>();
    }

    public Board getBoard() {
        return board;
    }
    public ArrayList<GameState> getChildren() {
        return children;
    }
    public Position getMoveFromPreviousState() {
        return moveFromPreviousState;
    }

    public void setMoveFromPreviousState(Position moveFromPreviousState) {
        this.moveFromPreviousState = moveFromPreviousState;
    }

}
