package Heuristics;
import  Game.GameState;

public interface Heuristic {
    public int evaluate(GameState node, int player);
}
