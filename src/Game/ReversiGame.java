package Game;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class ReversiGame {
    private Player player1;
    private Player player2;
    private ArrayList<Player> players = new ArrayList<>();
    boolean gameFinished;

    private int winner;

    public Board getBoard() {
        return board;
    }

    private Board board;

    public ReversiGame(Player player1, Player player2, int height, int width) {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board(height, width);
        Position.initializeAllPositions(height, width);
        players.add(player1);
        players.add(player2);
    }

    public void ReversiGameDraft() {
        board.initializeBoard();
        board.setPlayer1Turn(!board.isPlayer1Turn());
        gameFinished = false;
        while (!gameFinished) {
            for (Player player : players) {
                player.setMoves(board);
                if (!player.getMoves().isEmpty()) {
                    while (!board.setDisk(player.putDisk(board)))
                        System.out.println("can't put here");
                    System.out.println();
                }
                board.setPlayer1Turn(!board.isPlayer1Turn());
            }
            if (board.isGameFinished()) {
                gameFinished = true;
            }
        }
        winner = board.getPlayer1DisksNumber() > board.getPlayer2DisksNumber() ? 1 : 2;
        System.out.println("Player 1: "+board.getPlayer1DisksNumber()+ " Player 2: "+board.getPlayer2DisksNumber());
       // board.printBoard();
    }

    public int didPlayer1Won()
    {
        return board.getPlayer1DisksNumber() > board.getPlayer2DisksNumber() ? 1 : 0;
    }

    public double getAverageTimeOfPlayer(int player)
    {
        return players.get(player).getAvgTimes();
    }

    public double getAverageCountOfPlayer(int player)
    {
        return players.get(player).getAvgCount();
    }

}
