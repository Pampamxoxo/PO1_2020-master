package it.unive.dais.po1.exercise1;


import java.util.Random;

/**
 * This class represents a player of the game
 *
 * @since 1.0
 */
public class Player {
    private Mark mark; //

    /**
     * Intializes a player using the given Mark
     * @param mark the mark of the player
     */
    public Player(Mark mark) {
        this.mark = mark;
    }

    /**
     * Plays a round of the game.
     *
     * @param board
     * @return true if the player was able to
     */
    public boolean play(TicTacToeBoard board) {
        Random rand = new Random();
        int xx = 0;
        int yy = 0;

        if(!board.isFull() && board.winner()==null) {
            do {
                xx = rand.nextInt(3);
                yy = rand.nextInt(3);
            }while(board.getMark(xx, yy) != null);

            board.put(mark, xx, yy);
            return true;
        }
        else
            return false;
    }
}
