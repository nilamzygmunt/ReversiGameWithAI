public class CountingTilesHeuristic implements Heuristic {
    @Override
    public int heuristic(GameState node) {
        Board board = node.getBoard();
        return 100 * (!board.isPlayer1Turn() ?  (board.getPlayer1DisksNumber() - board.getPlayer2DisksNumber())
                : (board.getPlayer2DisksNumber() - board.getPlayer1DisksNumber()))
                / (board.getPlayer1DisksNumber() + board.getPlayer2DisksNumber());

    }
}
