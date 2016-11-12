package minedodger;

import java.io.PrintStream;
import java.util.*;

import static minedodger.Constants.NUM_SQUARES;
import static minedodger.Constants.ROW_LENGTH;

/**
 * Created by craig on 02/11/2016.
 */
public class Board {

    private List<Square> squares = new ArrayList<>();
    
    public Board()
    {
        build();
    }
    
    private void build()
    {
        Set<Integer> minedIds = new HashSet<>();

        Random r = new Random();
        for (int i = 0; i < Constants.NUM_MINES; i++){
            minedIds.add(r.nextInt(Constants.NUM_SQUARES));
        }

        for (int i = 0 ; i < NUM_SQUARES; i++)
        {
            squares.add(new Square(i, minedIds.contains(i)));
        }
    }

    public Square square(int id)
    {
        return squares.get(id);
    }

    public void print(Player p, PrintStream out){
        int start = NUM_SQUARES-ROW_LENGTH;
        int end = NUM_SQUARES;
        while (start >= 0) {
            List<Square> row = squares.subList(start, end);
            for (int col = 0; col < ROW_LENGTH; col++)
            {
                Square next = row.get(col);
                if (p.currentSquare().getId()== next.getId())
                {
                    out.print("P ");
                }
                else if (next.isMined())
                {
                    out.print("* ");
                }
                else {
                    out.print("  ");
                }
                out.print("|");
            }

            out.println();

            start -= ROW_LENGTH;
            end -= ROW_LENGTH;
        }

        //System.out.println("current sq" + p.currentSquare().getId());
    }

    public Square move(Square currentSquare, Move move) {
        return square(currentSquare.getId() + move.getIncrement());
    }
}
