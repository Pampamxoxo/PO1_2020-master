package it.unive.dais.po1.exercise2.m882620;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

/**
 * This class represents a tic tac toe board
 *
 * @since 1.0
 */
public class TicTacToeBoard extends Board {

    private Mark[][] board = new Mark[3][3];

    public TicTacToeBoard(){
        super(3);
    }

    /**
     * Puts a mark in a given cell
     *
     * @param c the mark to put in the board
     * @param x the x coordinate of the cell to be filled
     * @param y the y coordinate of the cell to be filled
     * @return true if the cell was empty, the game was not ended (e.g., no winner yet) and
     * it filled it, false otherwise
     */
    public boolean put(Mark c, int x, int y) {
        if(winner() == null && board[x][y] == null){
            board[x][y] = c;
            return true;
        }
        else
            return false;
    }

    /**
     * Returns the mark of a cell, null if empty
     * @param x the x coordinate of the cell
     * @param y the y coordinate of the cell
     * @return the mark in the given cell, null if the cell is empty
     */
    /*public Mark getMark(int x, int y) {
        return  board[x][y];
    }*/

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    public Mark winner() {
        Mark vinc = null;

        for(int i = 0; i<3 && vinc==null ; i++){
            if(board[i][0] == board[i][1] && board[i][0] == board[i][2])
                vinc = this.getMark(i,0);
        }
        for(int i = 0; i<3 && vinc==null ; i++){
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i])
                vinc = this.getMark(0,i);
        }

        if(vinc==null && board[0][0] == board[1][1] && board[0][0] == board[2][2])
            vinc = this.getMark(0,0);

        if(vinc==null && board[0][2] == board[1][1] && board[0][2] == board[2][0])
            vinc = this.getMark(0,2);

        return vinc;
    }

    /**
     * Returns true if the board is full
     *
     * @return true iff the board is full
     */
    public boolean isFull() {
        boolean check = true;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(this.getMark(i, j) == null)
                    check = false;
            }
        }
        return check;
    }

}
