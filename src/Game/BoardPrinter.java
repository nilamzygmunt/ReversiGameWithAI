package Game;
public class BoardPrinter {
    public void printState(Board board, int tabNum)
    {
        for(int i = 0; i <board.getHeight(); i++)
        {
            for(int t = 0; t< tabNum ; t++)
            {
                System.out.print("\t");
            }
            for(int j = 0; j<board.getWidth(); j++) {
                if(board.getBoard()[i][j] == 1)
                    System.out.print("\u001B[33m"+board.getBoard()[i][j]+"\u001B[0m");
                else  if(board.getBoard()[i][j] ==2)
                    System.out.print("\u001B[36m"+board.getBoard()[i][j]+"\u001B[0m");
                else System.out.print(board.getBoard()[i][j]);
            }
            System.out.println();

        }
        System.out.println();
    }
    public void printBoard(Board board)
    {
        for(int i = 0; i <2*board.getHeight(); i++)
        {
            for(int j = 0; j<board.getWidth(); j++)
            {
                if(i%2==0) {
                    System.out.print("+----");
                    if (j == board.getWidth()-1)
                        System.out.print("-");
                }
                else
                {
                    if(board.getBoard()[i-(i/2)-1][j] == 1)
                        System.out.print("| "+printPlayerDisk(1)+" ");
                    else  if(board.getBoard()[i-(i/2)-1][j] ==2)
                        System.out.print("| "+printPlayerDisk(2)+" ");
                    else System.out.print("|    ");
                    if(j == board.getWidth()-1)
                        System.out.print("|");
                }
            }
            System.out.println();
        }
        for(int i = 0; i<board.getWidth(); i++)
        {
            System.out.print("+----");
            if (i == board.getWidth()-1)
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
