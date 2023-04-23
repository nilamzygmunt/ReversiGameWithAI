public class CornerHeuristic implements Heuristic{
    @Override
    public int heuristic(GameState node) {
        Board board = node.getBoard();
        return 100 * (!board.isPlayer1Turn() ?  (board.getPlayer1DisksNumber() - board.getPlayer2DisksNumber())
                : (board.getPlayer2DisksNumber() - board.getPlayer1DisksNumber()))
                / (board.getPlayer1DisksNumber() + board.getPlayer2DisksNumber()) + 100 * cornerValue(board);

    }

    private int cornerValue(Board board)
    {
        int i = 0;
        i += board.getBoard()[0][board.getWidth()-1] == board.getPlayerColor() ? 1 : 0;
        i += board.getBoard()[board.getHeight()-1][0] == board.getPlayerColor() ? 1 : 0;
        i += board.getBoard()[board.getHeight()-1][board.getWidth()-1] == board.getPlayerColor() ? 1 : 0;
        i += board.getBoard()[0][0] == board.getPlayerColor() ? 1 : 0;

        return i;
    }
}
