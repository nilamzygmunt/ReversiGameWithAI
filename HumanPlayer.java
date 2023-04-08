import java.util.Scanner;

public class HumanPlayer implements Player
{
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    private int playerId;

    public HumanPlayer(int playerId)
    {
        this.playerId = playerId;
    }
    @Override
    public Position putDisk() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your move:");
        int posX = input.nextInt();
        int posY = input.nextInt();
        return new Position(posX-1, posY-1);
    }
}
