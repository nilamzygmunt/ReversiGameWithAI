
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    Board boardFourxFour = new Board(4, 4);
    @BeforeEach
    public void init()
    {
        boardFourxFour.initializeBoard();
    }

    @Test
    void capturesHorizontally()
    {
        boardFourxFour.getState();
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(0, 2));
    }

    @Test
    void capturesMultipleHorizontally()
    {
        boardFourxFour.getBoard()[2][2] = 2;
        boardFourxFour.getBoard()[3][2] = 1;
        boardFourxFour.getState();
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(0, 2));
    }

    @Test
    void capturesVertically()
    {
        boardFourxFour.getState();
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(2, 0));
    }

    @Test
    void capturesMultipleVertically()
    {
        boardFourxFour.getBoard()[2][2] = 2;
        boardFourxFour.getBoard()[2][3] = 1;
        boardFourxFour.getState();
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(2, 0));
    }
}
