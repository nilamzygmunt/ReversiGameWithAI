import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer implements Player
{
    private int playerId;
    public HumanPlayer(int playerId)
    {
        this.playerId = playerId;
    }
    public int getPlayerId() {
        return playerId;
    }

    @Override
    public void getMoves(ArrayList<Position> moves) {

    }
    @Override
    public Position putDisk() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your move:");
        int posX = input.nextInt();
        int posY = input.nextInt();
        return Position.getPosition(posX, posY);
    }
}
