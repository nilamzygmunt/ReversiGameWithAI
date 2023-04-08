public class ReversiGame {
    private Player player1;
    private Player player2;

    public Board getBoard() {
        return board;
    }

    private Board board;

    ReversiGame(Player player1, Player player2, int height, int width)
    {
        this.player1 = player1;
        this.player2 = player2;
        board = new Board(height, width);
    }

    public void ReversiGameDraft()
    {
        board.initializeBoard();
        for(int i =0; i < 10; i++) {
            board.getState();
            board.setPlayer1Turn(true);
            board.getAvailableMoves();
            if (!board.setDisk(player1.putDisk()))
                System.out.println("cant put here");
            System.out.println((board.printPlayerDisk(player1.getPlayerId())));
            board.printBoard();
            board.getState();
            board.setPlayer1Turn(false);
            if (!board.setDisk(player2.putDisk()))
                System.out.println("cant put here");
            System.out.println((board.printPlayerDisk(player2.getPlayerId())));
            board.printBoard();
            board.getState();

        }

    }
}
