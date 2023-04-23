package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements Player
{
    private int playerId;
    ArrayList<Position> moves;
    public HumanPlayer(int playerId)
    {
        this.playerId = playerId;
    }
    public int getPlayerId() {
        return playerId;
    }
    public double getAvgTimes() {return 0;}
    @Override
    public ArrayList<Position> getMoves() {
        return moves;
    }
    @Override
    public double getAvgCount()
    {return 0;}
    @Override
    public void setDepth(int depth) {
    }

    @Override
    public void setMoves(Board board) {
        moves = board.getAvailableMoves();
    }
    @Override
    public Position putDisk(Board board) {
        Scanner input = new Scanner(System.in);
        System.out.println("Available Moves: "+ moves);
        System.out.println("Enter your move:");
        int posX = input.nextInt();
        int posY = input.nextInt();
        return Position.getPosition(posX, posY);
    }
}
