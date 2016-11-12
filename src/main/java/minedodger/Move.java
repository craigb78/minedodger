package minedodger;

/**
 * Created by craig on 02/11/2016.
 */
public enum Move {
    U('U', "Move up", 8),D('D', "Move down", -8),L('L', "Move left", -1),R('R', "Move right", 1);

    private char ch;
    private int increment;
    private String desc;

     Move(char ch, String desc, int increment){
        this.ch = ch;
        this.desc = desc;
        this.increment = increment;
    }

    public char getKey() {
        return ch;
    }

    public int getIncrement() {
        return increment;
    }

    public static Move parse(char ch)
    {
        for (Move m : values())
        {
            if (m.ch == ch)
            {
                return m;
            }
        }
        return null;
    }

    public String getDescription() {
        return desc;
    }
}
