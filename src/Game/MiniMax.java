package Game;

import Heuristics.Heuristic;

import java.util.ArrayList;
import java.util.Random;

public class MiniMax {

    GameStateTree tree = new GameStateTree();
    public static Random rand = new Random();
    int MAX_DEPTH = 2;
    int evaluationCounter =0;
    int player;

    public MiniMax(int depth, int player) {
        this.MAX_DEPTH = depth;
    }

    public int minimax(GameState node, int depth, boolean maximizingPlayer, Heuristic heuristic, int tabNum) {
        if (depth == 0 || node.getBoard().getAvailableMoves().size() == 0)
        {
            int val = (int) heuristic.evaluate(node, player);
            evaluationCounter++;
            return val;
        }
        addMovesAsChildren(node);
        if (maximizingPlayer)
        {

            int value= Integer.MIN_VALUE;
            for(GameState nodeChild : node.getChildren())
            {
//                for(int i = 0; i <tabNum; i++)
//                    System.out.print("\t");
//                System.out.print("maximizing: "+ " "+value+"\n");
                value = Math.max(value, minimax(nodeChild, depth-1, false, heuristic, tabNum+1));
//                for(int i = 0; i <tabNum; i++)
//                    System.out.print("\t");
//                System.out.print("nr: "+" "+nodeChild.score+"\n");
            }
            return value;
        }
        else
        {
            int value = Integer.MAX_VALUE;

            for(GameState nodeChild : node.getChildren())
            {
//                for(int i = 0; i <tabNum; i++)
//                    System.out.print("\t");
//                System.out.print("minimizing: "+ " "+value+"\n");
                value = Math.min(value, minimax(nodeChild, depth-1, true, heuristic , tabNum+1));
//                for(int i = 0; i <tabNum; i++)
//                    System.out.print("\t");
//                System.out.print("nr: "+" "+nodeChild.score+"\n");

            }
            return value;
        }
    }

    public int minimaxAlphaBeta(GameState node, int depth, int alpha, int beta, boolean maximizingPlayer, Heuristic heuristic) {
        if (depth == 0 || node.getBoard().getAvailableMoves().size() == 0)
        {
            int val = (int) heuristic.evaluate(node, player);
            evaluationCounter++;
            return val;
        }
        addMovesAsChildren(node);
        if (maximizingPlayer)
        {
            int value= Integer.MIN_VALUE;
            for(GameState nodeChild : node.getChildren())
            {
                value = Math.max(value, minimaxAlphaBeta(nodeChild, depth-1, alpha, beta,false, heuristic));
                if(value > beta) {
                    break;
                }
                alpha = Math.max(alpha, value);
            }
            return value;
        }
        else
        {
            int value = Integer.MAX_VALUE;
            for(GameState nodeChild : node.getChildren())
            {
                value = Math.min(value, minimaxAlphaBeta(nodeChild, depth-1, alpha, beta,true, heuristic ));
                if(value < alpha) {
                    break;
                }
                beta = Math.min(beta, value);
            }
            return value;
        }
    }

    public Position findBestMove(Board board, Heuristic heuristic, boolean alphaBeta)
    {
        boolean moveValid = false;
        GameState originalGameState  = new GameState(board);
        Position bestMove = Position.getPosition(0,0);
        int bestScore = Integer.MIN_VALUE;
        addMovesAsChildren(originalGameState);
        for(GameState child : originalGameState.getChildren())
        {
            if(alphaBeta)
                child.score = minimaxAlphaBeta(child, MAX_DEPTH, Integer.MIN_VALUE, Integer.MAX_VALUE, false, heuristic);
            else child.score = minimax(child, MAX_DEPTH,false, heuristic,0);
        }
        for(GameState child : originalGameState.getChildren())
        {
            if(!moveValid)
            {
                bestMove = child.getMoveFromPreviousState();
            }
            if((child.score >= bestScore ))//&& !moveValid) || ((child.score > bestScore) || (child.score == bestScore && rand.nextBoolean())))
            {
                bestScore = child.score;
                bestMove = child.getMoveFromPreviousState();
                moveValid = true;
            }
        }
        return bestMove;
    }
    public void addMovesAsChildren(GameState gameState)
    {
        ArrayList<Position> moves = gameState.getBoard().getAvailableMoves();
        if(tree.getRoot() == null)
        {
            tree.addChild(null, gameState);
        }
        for(Position pos : moves)
        {
            Board childBoard = gameState.getBoard().clone();
            childBoard.setDisk(pos);
            GameState childGamestate = new GameState(childBoard);
            childGamestate.setMoveFromPreviousState(pos);
            childBoard.setPlayer1Turn(!childBoard.isPlayer1Turn());
            tree.addChild(gameState, childGamestate);

        }
    }
    public int getEvaluationCounter()
    {
        return evaluationCounter;
    }

    public void print()
    {
        tree.printTree(tree.getRoot(), 0);
    }


}
