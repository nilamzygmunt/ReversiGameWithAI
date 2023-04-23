
import Game.Board;
import Game.Position;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    //test diagonally, test multiple direction captuee, test near oboarder
    Board boardFourxFour = new Board(4, 4);


    @BeforeEach
    public void init()
    {
        boardFourxFour.initializeBoard();
        Position.initializeAllPositions(4, 4);
    }

    @Test
    void capturesHorizontally()
    {
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove( Position.getPosition(0, 2)));
    }

    @Test
    void capturesMultipleHorizontally()
    {
        boardFourxFour.getBoard()[2][2] = 2;
        boardFourxFour.getBoard()[3][2] = 1;
        boardFourxFour.setPlayer1Turn(true);
        boardFourxFour.printBoard();
        assertTrue(boardFourxFour.isLegalMove(Position.getPosition(0, 2)));
    }

    @Test
    void capturesVertically()
    {
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(Position.getPosition(2, 0)));
    }

    @Test
    void capturesMultipleVertically()
    {
        boardFourxFour.getBoard()[2][2] = 2;
        boardFourxFour.getBoard()[2][3] = 1;
        boardFourxFour.setPlayer1Turn(true);
        assertTrue(boardFourxFour.isLegalMove(Position.getPosition(2, 0)));
    }

    @Test
    void countAfterCapture()
    {

        boardFourxFour.printState(0);
        boardFourxFour.setPlayer1Turn(true);
        boardFourxFour.getAvailableMoves();
        boardFourxFour.setDisk(Position.getPosition(2, 0));
        boardFourxFour.printState(0);
        assertEquals(4, boardFourxFour.getPlayer1DisksNumber());
    }

    @Test
    void differentMovesArraylistInBoardClone()
    {
        boardFourxFour.getAvailableMoves();
        Board boardClone = boardFourxFour.clone();
        assertFalse(boardClone.getMoves() == boardFourxFour.getMoves());
    }

    @Test
    void samePositionObjectsInMovesInBoardClone()
    {
        boardFourxFour.getAvailableMoves();
        Board boardClone = boardFourxFour.clone();
        for(Position move : boardFourxFour.getMoves())
        {
            assertTrue(boardClone.getMoves().contains(move));
        }
        assertTrue(boardClone.getMoves().size() == boardFourxFour.getMoves().size());
    }

    @Test
    void differentFlipsHashMapInBoardClone()
    {
        boardFourxFour.getAvailableMoves();
        Board boardClone = boardFourxFour.clone();
        System.out.println(boardClone.getFlips());
        System.out.println(boardFourxFour.getFlips());
        assertFalse(boardClone.getFlips() == boardFourxFour.getFlips());
    }

    @Test
    void sameKeysAndValsObjectsInFlipsInBoardClone()
    {
        boardFourxFour.getAvailableMoves();
        Board boardClone = boardFourxFour.clone();
        for(ArrayList<Position> key : boardFourxFour.getFlips().keySet())
        {
            assertTrue(boardClone.getFlips().get(key) == boardFourxFour.getFlips().get(key));
        }
    }
//NEED PROPER SET UP OF BOARD
//    @Test
//    void capturesDiagonally()
//    {
//        boardFourxFour.setPlayer1Turn(true);
//        assertTrue(boardFourxFour.isLegalMove(new Game.Position(2, 0)));
//    }
//
//    @Test
//    void capturesMultipleDiagonally()
//    {
//        boardFourxFour.getBoard()[2][2] = 2;
//        boardFourxFour.getBoard()[2][3] = 1;
//        boardFourxFour.setPlayer1Turn(true);
//        assertTrue(boardFourxFour.isLegalMove(new Game.Position(2, 0)));
//    }
}
