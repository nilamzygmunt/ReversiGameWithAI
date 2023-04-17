import java.lang.reflect.Array;
import java.util.ArrayList;

public class ReversiGame {
    private Player player1;
    private Player player2;

    private MiniMax miniMax = new MiniMax();
    private ArrayList<Player> players = new ArrayList<>();
    boolean gameFinished;


    public Board getBoard() {
        return board;
    }

    private Board board;

    ReversiGame(Player player1, Player player2, int height, int width) {
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
        board.printBoard();
        ArrayList<Position> moves = board.getAvailableMoves();
        while (!gameFinished) {
            for (Player player : players) {
                System.out.println("PLAYER: " + player.getPlayerId());
                System.out.println(miniMax.minimax(board, 3, true));
                miniMax.print();
                System.out.println("**************************************************");
                board.printState(4);
                System.out.println("Player 1: "+board.getPlayer1DisksNumber()+" Player 2: "+board.getPlayer2DisksNumber());
                System.out.println("his moves: " + moves);
                if (moves.size() > 0) {
                    player.getMoves(moves);
                    System.out.println(moves);
                    while (!board.setDisk(player.putDisk()))
                        System.out.println("can't put here");
                    board.printBoard();
                    System.out.println();
                }
                board.setPlayer1Turn(!board.isPlayer1Turn());
                moves = board.getAvailableMoves();
            }
            if (moves.isEmpty()) {
                gameFinished = !canSomeonePleaseMakeAMove();
            }

        }

    }

    boolean canSomeonePleaseMakeAMove() {
        board.setPlayer1Turn(!board.isPlayer1Turn());
        ArrayList<Position> moves = board.getAvailableMoves();
        return moves.size() > 0;

    }
}
