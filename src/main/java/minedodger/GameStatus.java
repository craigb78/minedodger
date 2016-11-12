package minedodger;

import java.io.PrintStream;

/**
 * Created by craig on 02/11/2016.
 */
public enum GameStatus {
    GAME_WIN("You have won!"), IN_PROGRESS("Victory is close at hand!"), GAME_OVER("Game Over! You hit too many mines!");

    private String msg;

    GameStatus(String msg)
    {
        this.msg=msg;
    }

    public String getMessage()
    {
        return this.msg;
    }

    public void print(PrintStream out)
    {
        out.println(getMessage());
    }
}
