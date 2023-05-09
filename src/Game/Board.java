package Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Board {

    private Integer[][] board;

    public int getHeight() {
        return height;
    }

    private int height;

    public int getWidth() {
        return width;
    }
    private int width;
    private boolean isPlayer1Turn;
    public int getPlayer1DisksNumber() {
        return player1DisksNumber;
    }
    private int player1DisksNumber;
    public int getPlayer2DisksNumber() {
        return player2DisksNumber;
    }

    private int player2DisksNumber;
    ArrayList<Boolean> moveCanCapture;
    ArrayList<Position> moves = new ArrayList<>();
    private HashMap<ArrayList<Position>, Position> flips = new HashMap<ArrayList<Position>, Position>();
    ArrayList<Board> children = new ArrayList<>();
    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        board = new Integer[height][width];
    }

    private Board(Board source) {
        board = new Integer[source.height][source.width];
        for (int i = 0; i < source.height; i++) {
            for (int j = 0; j < source.width; j++) {
                this.board[i][j] = source.board[i][j];
            }
        }
        this.height = source.height;
        this.width = source.width;
        this.isPlayer1Turn = source.isPlayer1Turn;
        this.moves = (ArrayList<Position>) source.moves.clone();
        this.flips = (HashMap<ArrayList<Position>, Position>) source.flips.clone();
        this.player1DisksNumber = source.player1DisksNumber;
        this.player2DisksNumber = source.player2DisksNumber;
    }

    public void initializeBoard()
    {
        for(int i = 0; i<height; i++)
        {
            for(int j= 0; j<width; j++)
            {
                board[i][j] = 0;
            }
        }
        board[(height-1)/2][(width-1)/2] = 1;
        board[height/2][width/2] = 1;
        board[(height-1)/2][width/2] = 2;
        board[height/2][(width-1)/2] = 2;
        player1DisksNumber = 2;
        player2DisksNumber = 2;
    }

    public ArrayList<Position> getAvailableMoves()
    {
        moves.clear();
        for(int i =0; i <height; i++)
        {
            for(int j = 0; j< width; j++)
            {
                if(board[i][j] == 0 && isLegalMove(Position.getPosition(i, j)))
                {
                    moves.add(Position.getPosition(i, j));
                }
            }
        }
        return moves;
    }

    public boolean isLegalMove(Position move)
    {
        moveCanCapture = new ArrayList<>(Arrays.asList( canCapture(move,1,1),
                canCapture(move,0,1),
                canCapture(move,1,0),
                canCapture(move,-1,-1),
                canCapture(move,-1,0),
                canCapture(move,0,-1),
                canCapture(move,1,-1),
                canCapture(move,-1,1)));
        if(moveCanCapture.contains(true))
            return true;
        else return false;
    }

    public boolean canCapture(Position move, int directionX, int directionY)
    {
        int posX = move.getPosX();
        int posY = move.getPosY();
        ArrayList<Position> possibleFlip = new ArrayList<>();
        posX += directionX;
        posY += directionY;
        if(isOutOfBoardRange(posX, posY) || board[posX][posY] != getOpponentColor()) {
            return false;
        }
        possibleFlip.add(Position.getPosition(posX, posY));
        while(board[posX][posY] != 0 )
        {
            if(board[posX][posY] == getPlayerColor()) {
                flips.put(possibleFlip, move);
                return true;
            }

            posX += directionX;
            posY += directionY;
            if(isOutOfBoardRange(posX, posY))
                return false;
            possibleFlip.add(Position.getPosition(posX, posY));

        }
        return false;
    }

    public boolean isOutOfBoardRange(int posX, int posY)
    {
        return posX<0 || posY < 0 || posX > width-1 || posY > height-1;
    }
    public boolean setDisk(Position move)
    {
        if(moves.contains(move)) {
            board[move.getPosX()][move.getPosY()] = getPlayerColor();
            changeDisksNumber(1, 0);
            flipOpponentsDisks(move);
            return true;
        }
        return false;
    }

    public void changeDisksNumber(int added, int flipped)
    {
        if (!isPlayer1Turn) {
            player2DisksNumber += added;
            player1DisksNumber -= flipped;
        }
        else
        {
            player1DisksNumber += added;
            player2DisksNumber -= flipped;
        }

    }
    public int getOpponentColor()
    {
        if(isPlayer1Turn)
            return 2;
        else return 1;
    }

    public int getPlayerColor()
    {
        if(isPlayer1Turn)
            return 1;
        else return 2;
    }
    public boolean isPlayer1Turn() {
        return isPlayer1Turn;
    }
    public void flipOpponentsDisks(Position move)
    {
        int flipCount = 0;
        for(ArrayList<Position> possibleFlips : flips.keySet())
        {
            if(flips.get(possibleFlips) == move)
            {
                //System.out.println(move);
                for (Position flip : possibleFlips)
                {
                  if(board[flip.getPosX()][flip.getPosY()] != getPlayerColor()) {
                      //System.out.println(flip);
                      board[flip.getPosX()][flip.getPosY()] = getPlayerColor();
                      flipCount++;
                  }
                }
            }
        }
        changeDisksNumber(flipCount, flipCount);
        flips.clear();
    }

    public Integer[][] getBoard() {
        return board;
    }
    public HashMap<ArrayList<Position>, Position> getFlips() {
        return flips;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }
    public boolean didThisPlayerWin(int player)
    {
        if(player == 1)
            return player1DisksNumber > player2DisksNumber;
        else return player2DisksNumber > player1DisksNumber;
    }
    public ArrayList<Position> getMoves() {
        return moves;
    }

    public void setPlayer1Turn(boolean player1Turn) {
        isPlayer1Turn = player1Turn;
    }

    public boolean isGameFinished()
    {
        boolean originalTurn = isPlayer1Turn;
        boolean gameFinished = false;
        if(getAvailableMoves().isEmpty())
        {
            setPlayer1Turn(!isPlayer1Turn);
            if(getAvailableMoves().isEmpty())
            {
                gameFinished = true;
            }
            else
            {
                gameFinished = false;
            }
        }
        isPlayer1Turn = originalTurn;
        return gameFinished;
    }
    public Board clone() {
        return new Board(this);
    }
}
