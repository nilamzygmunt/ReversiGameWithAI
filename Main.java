public class Main {
    public static void main(String[] args) {

//        Integer[][] gameState = new Integer[8][8];
//        for(int i = 0; i < gameState.length; i++)
//        {
//            for(int j = 0; j< gameState[i].length; j++)
//            {
//                if(j%2==0 && i%2 ==0)
//                    gameState[i][j] = 1;
//                else if((j%2!=0 && i%2 !=0))
//                    gameState[i][j] = 2;
//                else
//                    gameState[i][j] =0;
//            }
//        }

        Player player1 = new HumanPlayer(1);
        Player player2 = new HumanPlayer(2);

        ReversiGame reversiGame = new ReversiGame(player1, player2, 4, 4);
        reversiGame.ReversiGameDraft();
        Board gameState = reversiGame.getBoard();
        gameState.printBoard();

    }
}
