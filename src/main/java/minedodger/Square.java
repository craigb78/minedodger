package minedodger;


/**
 * Created by craig on 02/11/2016.
 */
public class Square {
    private int id;
    private boolean mined;

    public Square(int id, boolean mined){
        this.id = id;
        this.mined = mined;
    }

    public boolean isMined()
    {
        return  this.mined;
    }

    public int getId() {
        return id;
    }

    public boolean isLegal(Move m){
        if (m == Move.D)
        {
            return !onBottomRow();
        }
        else if (m == Move.U)
        {
            return !onTopRow();
        }
        else if (m  == Move.L)
        {
            return 0 != (id % Constants.ROW_LENGTH);
        }
        else if (m == Move.R)
        {
            return 0 != ((1+id) % Constants.ROW_LENGTH);
        }
        throw new IllegalStateException("unsupported move type: " + m);
    }

    private boolean onBottomRow() {
        return id >= 0 && id < Constants.ROW_LENGTH;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square){
            Square that =  (Square) obj;

            return this.id == that.id;
        }
        return false;
    }

    public boolean onTopRow() {

        return id < Constants.NUM_SQUARES && id >= (Constants.NUM_SQUARES - Constants.ROW_LENGTH);
    }
}
