public class Main {
    public static void main(String[] args) {
        Player player1 = new HumanPlayer(1);
        Player player2 = new HumanPlayer(2);

        ReversiGame reversiGame = new ReversiGame(player1, player2, 4, 4);
        reversiGame.ReversiGameDraft();
        Board gameState = reversiGame.getBoard();
        gameState.printBoard();

    }
}
