import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MiniMax {

    GameStateTree tree = new GameStateTree();
    int MAX_DEPTH = 2;

    //UWAGI: MINIMAX CHYBA działa okej, najlepiej zostawić debugi w samym minimaxie, najprawodpodpobniej skasować score
    // w GameState, bo jest mylący, jutro refaktor kodu i heurystyka
    public void initTestTree()
    {
         GameState og = new GameState(new Board(0, 0));
         GameStateTree ogr = new GameStateTree();
         ogr.setRoot(og);
         GameState ch1 = new GameState(new Board(0, 0));
         ch1.lvl = 1;
         GameState ch2 = new GameState(new Board(0, 0));
         ch2.lvl = 2;
         GameState ch11 = new GameState(new Board(0, 0));
         ch11.lvl = 3;
         GameState ch12 = new GameState(new Board(0, 0));
         ch12.lvl = 4;
         GameState ch21 = new GameState(new Board(0, 0));
         ch21.lvl = 5;
         GameState ch22 = new GameState(new Board(0, 0));
         ch22.lvl = 6;
         GameState ch23 = new GameState(new Board(0, 0));
         ch23.lvl = 7;
         ogr.addChild(og, ch1);
         ogr.addChild(og, ch2);
         ogr.addChild(ch1, ch11);
         ogr.addChild(ch1, ch12);
         ogr.addChild(ch2, ch21);
         ogr.addChild(ch2, ch22);
         ogr.addChild(ch2, ch23);
        System.out.println(minimax(og, MAX_DEPTH, true, 0));
         ogr.printTree(og, 0);


    }
    public int minimax(GameState node, int depth, boolean maximizingPlayer, int tabNum) {
        //System.out.println(depth);
        if (depth == 0)// || node.getBoard().getAvailableMoves().size() == 0) // || gameFinished
        {
            int val = (int) testHeuristic(node, tabNum);
            node.score = val;
            return val;
        }
        addMovesAsChildren(node);
        //.out.println("bubu");
        //System.out.println("tab: "+tabNum);
        if (maximizingPlayer)
        {
            int value= Integer.MIN_VALUE;
            for(GameState nodeChild : node.getChildren())
            {
                for(int i = 0; i <tabNum; i++)
                    System.out.print("\t");
                System.out.print("maximizing: "+nodeChild.lvl + " "+value+"\n");
                //value= Integer.MIN_VALUE;
                //System.out.println("FOR CHILD: "+nodeChild.lvl +" curr val: "+ value);
                value = Math.max(value, minimax(nodeChild, depth-1, false, tabNum+1));
                nodeChild.score = value;
                for(int i = 0; i <tabNum; i++)
                    System.out.print("\t");
                System.out.print("nr: "+nodeChild.lvl +" "+nodeChild.score+"\n");
            }
            return value;
        }
        else
        {

            int value = Integer.MAX_VALUE;
            for(GameState nodeChild : node.getChildren())
            {
                for(int i = 0; i <tabNum; i++)
                    System.out.print("\t");
                System.out.print("minimizing: "+nodeChild.lvl + " "+value+"\n");
                //System.out.println("FOR CHILD: "+nodeChild.lvl +" curr val: "+ value);
                value = Math.min(value, minimax(nodeChild, depth-1, true, tabNum+1));
                nodeChild.score = value;
                for(int i = 0; i <tabNum; i++)
                    System.out.print("\t");
                System.out.print("nr: "+nodeChild.lvl +" "+nodeChild.score+"\n");

            }
            return value;
        }
    }

    public Position findBestMove(Board board)
    {
        GameState originalGameState  = new GameState(board);
        Position bestMove = Position.getPosition(0,0);
        int maxVal = Integer.MIN_VALUE;
        originalGameState.minimizing = true;
        //addMovesAsChildren(originalGameState);
        //tree.printTree(tree.getRoot(), 0);
       // System.out.println("%%%%%%%%%%%");
        //tree.setRoot(originalGameState);
        int bestScore = minimax(originalGameState, MAX_DEPTH, true, 0);

        for(GameState child : originalGameState.getChildren())
        {
            if(child.score > maxVal)
            {
                maxVal = child.score;
                bestMove = child.moveHistory.get(0);
            }
        }
        return bestMove;
        //initTestTree();
    }
    public void addMovesAsChildren(GameState gameState)
    {
        //ArrayList<Board> childrenBoard = new ArrayList<>();
        ArrayList<Position> moves = gameState.getBoard().getAvailableMoves();
        //gameState.getBoard().printState(0);
        //int i =0;
        //System.out.println("level of depth: "+i);
        if(tree.getRoot() == null)
        {
            tree.addChild(null, gameState);
        }
        for(Position pos : moves)
        {
            Board childBoard = gameState.getBoard().clone();
            //overload equals
           // System.out.println("BEF");
            //childBoard.printState(1);
            childBoard.setDisk(pos);
           // System.out.println("AF");
            //childrenBoard.add(childBoard);
            //childBoard.printState(1);
            GameState childGamestate = new GameState(childBoard);
            childGamestate.moveHistory.add(pos);
            childGamestate.minimizing = !gameState.minimizing;
            childGamestate.lvl = gameState.lvl+1;
            childBoard.setPlayer1Turn(!childBoard.isPlayer1Turn());
            tree.addChild(gameState, childGamestate);

        }
    }

    public double heuristic(Board node)
    {
        return (100*(node.getPlayer1DisksNumber() - node.getPlayer2DisksNumber())) /(node.getPlayer1DisksNumber() + node.getPlayer2DisksNumber());
    }

    public double testHeuristic(GameState node, int tabNum)
    {
        //System.out.println("for: ");
        //node.getBoard().printState(0);
        Random rand = new Random(5675675);
        int val =  1 * (int) (Math.random() * 100) + rand.nextInt(7);
        node.score = val;
        for(int i = 0; i <tabNum; i++)
            System.out.print("\t");
        System.out.println("h :"+val);
        return val;
    }

    public void print()
    {
        tree.printTree(tree.getRoot(), 0);
    }


}
