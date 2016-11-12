package minedodger;

/**
 * Created by craig on 02/11/2016.
 */
public class Player {
    private int minesHit = 0;
    private Square currentSquare;
    private Board board;

    public Player(Board board) {
        this.board = board;
        this.currentSquare = this.board.square(0);
    }

    public GameStatus getGameStatus()
    {
        if (minesHit == Constants.MINE_LIMIT)
        {
            return GameStatus.GAME_OVER;
        }
        else if (currentSquare.onTopRow())
        {
            return GameStatus.GAME_WIN;
        }
        return GameStatus.IN_PROGRESS;
    }

    public boolean move(Move move){
        if (currentSquare.isLegal(move)) {
            currentSquare = board.move(currentSquare, move);
            if (currentSquare.isMined())
            {
                ++minesHit;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public Square currentSquare() {
        return currentSquare;
    }
}
