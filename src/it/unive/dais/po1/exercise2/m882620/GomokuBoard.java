package it.unive.dais.po1.exercise2.m882620;

import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

public class GomokuBoard extends Board {

    /**
     * Creates a square board
     *
     * @param dimension the dimension of the square board
     */
    public GomokuBoard(int dimension) {
        super(dimension);
    }

    private Mark orizz(int x, int y, Mark segno){
        if(getMark(x,y+1) == segno && getMark(x,y+2) == segno && getMark(x,y+3) == segno && getMark(x,y+4) == segno)
            return segno;
        else
            return null;
    }

    private Mark vertic(int x, int y, Mark segno){
        if(getMark(x+1,y) == segno && getMark(x+2,y) == segno && getMark(x+3,y) == segno && getMark(x+4,y) == segno)
            return segno;
        else
            return null;
    }

    private Mark diagLtoR(int x, int y, Mark segno){
        if(getMark(x+1,y+1) == segno && getMark(x+2,y+2) == segno && getMark(x+3,y+3) == segno && getMark(x+4,y+4) == segno)
            return segno;
        else
            return null;
    }

    private Mark diagRtoL(int x, int y, Mark segno){
        if(getMark(x+1,y-1) == segno && getMark(x+2,y-2) == segno && getMark(x+3,y-3) == segno && getMark(x+4,y-4) == segno)
            return segno;
        else
            return null;
    }

    public Mark winner() {
        Mark vincitore = null;
        for (int i = 0; i<getDimension() && vincitore==null; i++) {
            for (int j = 0; j<getDimension() && vincitore==null; j++) {
                Mark segno = getMark(i,j);
                if(segno != null) {
                    if (getDimension()-j>=5)
                        vincitore = orizz(i, j, segno);
                    if (vincitore == null && getDimension()-i>=5)
                        vincitore = vertic(i, j, segno);
                    if (vincitore == null && getDimension()-i>=5 && getDimension()-j>=5)
                        vincitore = diagLtoR(i, j, segno);
                    if (vincitore == null && getDimension()-i>=5 && j>=4)
                        vincitore = diagRtoL(i, j, segno);
                }
            }
        }
        return vincitore;
    }
}