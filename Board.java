import java.util.ArrayList;

public class Board {


    private Integer[][] board;
    private int height;
    private int width;
    private boolean isPlayer1Turn;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        board = new Integer[height][width];
    }

    private Board(Board source) {
        System.arraycopy(source.board, 0, this.board, 0, source.height);
        this.height = source.height;
        this.width = source.width;
        this.isPlayer1Turn = source.isPlayer1Turn;
    }

    public Board clone() {
      return new Board(this);
    }

    public void initializeBoard()
    {
        for(int i = 0; i<height; i++)
        {
            for(int j= 0; j<height; j++)
            {
                board[i][j] = 0;
            }
        }
        board[(height-1)/2][(width-1)/2] = 1;
        board[height/2][width/2] = 1;
        board[(height-1)/2][width/2] = 2;
        board[height/2][(width-1)/2] = 2;
    }

    public boolean setDisk(Position move)
    {
        if(isLegalMove(move.getPosX(), move.getPosY())) {
            board[move.getPosX()][move.getPosY()] = getPlayerColor();
            return true;
        }
        return false;
    }

    public boolean isLegalMove(int posX, int posY)
    {
        if (posX<0 || posX > width || posY < 0 || posY > height) {
            System.out.println("xxx");
            return false;
        }
        if(board[posX][posY] != 0) {
            return false;
        }
        if(canCapture(posX,posY,1,1) ||
            canCapture(posX,posY,0,1) ||
                canCapture(posX,posY,1,0) ||
                canCapture(posX,posY,-1,-1) ||
                canCapture(posX,posY,-1,0) ||
                canCapture(posX,posY,0,-1) ||
                canCapture(posX,posY,1,1))
            return true;
        else return false;

        //and can capture
        //possible captures.set(move, capture)
        //if capture.size ==0 then no valid moves
        //if move +1 +1 has opponent then see if it can caputure it by applying move +1+1 until it finds one or goes beyond border or meets 0

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

    public boolean canCapture(int posX, int posY, int directionX, int directionY)
    {

        System.out.println("d:"+directionX+directionY);
        posX += directionX;
        posY += directionY;
        System.out.println("x: "+posX+"y: "+posY);
        System.out.println("con1:" + (posX<0) +"cond2: "+ (posY<0)+ "cond3: "+(posX > width-1)+"cond 4: "+(posY > height-1));
        getposinState(posX, posY);
        if(posX<0 || posY < 0 || posX > width-1 || posY > height-1 ||
                board[posX][posY] != getOpponentColor())
            return false;
        System.out.println("cond5: "+(board[posX][posY]));
        if(posX == width || posY == height)
            return false;
//        posX += directionX;
//        posY += directionY;
        while(board[posX][posY] != 0 )
        {

            if(board[posX][posY] == getPlayerColor())
                return true;
            posX += directionX;
            posY += directionY;
            getposinState(posX, posY);
            if(posX == width || posY == height)
                return false;
            System.out.println("x: "+posX+"y "+posY);
        }
        return false;
    }
    public void getAvailableMoves()
    {
        ArrayList<Position> moves = new ArrayList<>();
        int playerDisks;
        for(int i =0; i <height; i++)
        {
            for(int j = 0; j< width; j++)
            {
                if(isLegalMove(i, j))
                {
                    moves.add(new Position(i, j));
                }
            }
        }
        System.out.println(moves);
        for(int i = 0; i <height; i++)
        {
            for(int j = 0; j<width; j++) {
                if(checkIfIsInMoves(i, j, moves))
                {
                    System.out.print("\u001B[32m"+board[i][j]+"\u001B[0m");

                }
                else  System.out.print(board[i][j]);

            }
            System.out.println();
        }
    }

    boolean checkIfIsInMoves(int i, int j, ArrayList<Position> moves)
    {
        for(Position move : moves)
        {
            if(move.getPosX() == i && move.getPosY() == j)
                return true;
        }
        return false;
    }

    public void getState()
    {
        for(int i = 0; i <height; i++)
        {
            for(int j = 0; j<width; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
            }
    }

    public void getposinState(int posX, int posY)
    {
        for(int i = 0; i <height; i++)
        {
            for(int j = 0; j<width; j++) {
                if(i == posX && j == posY)
                {
                    System.out.print("\u001B[32m"+board[i][j]+"\u001B[0m");

                }
                else  System.out.print(board[i][j]);

            }
            System.out.println();
        }
    }
    public Integer[][] getBoard() {
        return board;
    }

    public void setBoard(Integer[][] board) {
        this.board = board;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isPlayer1Turn() {
        return isPlayer1Turn;
    }

    public void setPlayer1Turn(boolean player1Turn) {
        isPlayer1Turn = player1Turn;
    }


    public void printBoard()
    {
        for(int i = 0; i <2*height; i++)
        {
            for(int j = 0; j<width; j++)
            {
                if(i%2==0) {
                    System.out.print("+----");
                    if (j == width-1)
                        System.out.print("-");
                }
                else
                {
                    if(board[i-(i/2)-1][j] == 1)
                        System.out.print("| "+printPlayerDisk(1)+" ");
                    else  if(board[i-(i/2)-1][j] ==2)
                        System.out.print("| "+printPlayerDisk(2)+" ");
                    else System.out.print("|    ");
                    if(j == width-1)
                        System.out.print("|");
                }
            }
            System.out.println();
        }
        for(int i = 0; i<width; i++)
        {
            System.out.print("+----");
            if (i == width-1)
                System.out.print("-");
        }
        System.out.println();

    }

    public String printPlayerDisk(int player)
    {
        if (player == 1)
            return "\u001B[33m"+"##"+"\u001B[0m";
        else return "\u001B[36m"+"<3"+"\u001B[0m";
    }
}
