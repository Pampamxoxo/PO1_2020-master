package it.unive.dais.po1.exercise2.m882620;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

import java.util.Random;

public class Player extends it.unive.dais.po1.exercise2.Player {

    /**
     * Intializes a player using the given Mark
     *
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        super(mark);
    }

    public boolean play(Board board) {
        Random rand = new Random();
        int xx = 0;
        int yy = 0;

        if(!board.isFull() && board.winner()==null) {

            if(!isPresent(board, ownMark)) {  //first move
                do {
                    xx = rand.nextInt(board.getDimension());
                    yy = rand.nextInt(board.getDimension());
                } while (board.getMark(xx, yy) != null);
            }
            else {  //next moves
                int[] pos = new int[2];
                do {
                    pos = getAMark(board, ownMark, xx, yy);
                    if(pos[0] != -1) {
                        xx = pos[0];
                        yy = pos[1];
                        pos = getNewPosition(board, xx, yy);
                        if (pos[0] != -1) {
                            xx = pos[0];
                            yy = pos[1];
                        } else if (yy + 1 < board.getDimension()) //pos[0] = -1
                            yy++;
                        else {
                            yy = 0;
                            xx++;
                        }
                    }
                    else{
                        do {
                            xx = rand.nextInt(board.getDimension());
                            yy = rand.nextInt(board.getDimension());
                        } while (board.getMark(xx, yy) != null);
                        pos[0] = 0;
                    }
                }while(pos[0] == -1);
            }
            board.putMark(ownMark, xx, yy);
            return true;
        }
        else
            return false;
    }

    public boolean isPresent(Board board, Mark marc){
        for (int i = 0; i<board.getDimension(); i++)
            for (int j = 0; j < board.getDimension(); j++)
                if(board.getMark(i,j) == marc)
                    return true;
        return false;
    }

    //start to search a mark from the given pos
    public int[] getAMark(Board board, Mark marc, int x, int y){
        int[] pos = {-1, -1};
        for (int i = x; i < board.getDimension(); i++)
            for (int j = y; j < board.getDimension(); j++)
                if(board.getMark(i,j) == marc) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
        return pos;
    }

    //gives an empty pos near the given pos
    public int[] getNewPosition (Board board, int x, int y){
        int[] pos = {-1, -1};
        int dim = board.getDimension();
        if(y+1<dim && board.getMark(x,y+1) == null) { //E
            pos[0] = x;
            pos[1] = y+1;
            return pos;
        }
        if(y-1>=0 && board.getMark(x,y-1) == null) { //W
            pos[0] = x;
            pos[1] = y-1;
            return pos;
        }
        if(x+1<dim && board.getMark(x+1,y) == null) { //S
            pos[0] = x+1;
            pos[1] = y;
            return pos;
        }
        if(x-1>=0 && board.getMark(x-1,y) == null) { //N
            pos[0] = x-1;
            pos[1] = y;
            return pos;
        }
        if(x+1<dim && y+1<dim && board.getMark(x+1,y+1) == null) { //SE
            pos[0] = x+1;
            pos[1] = y+1;
            return pos;
        }
        if(x-1>=0 && y-1>=0 && board.getMark(x-1,y-1) == null) { //NW
            pos[0] = x-1;
            pos[1] = y-1;
            return pos;
        }
        if(x+1<dim && y-1>=0 && board.getMark(x+1,y-1) == null) { //SW
            pos[0] = x+1;
            pos[1] = y-1;
            return pos;
        }
        if(x-1>=0 && y+1<dim && board.getMark(x-1,y+1) == null) { //NE
            pos[0] = x-1;
            pos[1] = y+1;
            return pos;
        }
        return pos;
    }
}
