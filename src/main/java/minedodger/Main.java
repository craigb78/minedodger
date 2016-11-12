package minedodger;

import java.io.IOException;

/**
 * Created by craig on 02/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            eventLoop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void eventLoop() throws IOException {
        Board board = new Board();
        Player player = new Player(board);

        printUsage();
        board.print(player, System.out);

        char ch = (char) System.in.read();
        while (ch != 'Q') {
            Move m = Move.parse(ch);
            if (m != null) {
                if (!player.move(m)) {
                    System.out.println("Illegal move!");
                }

                board.print(player, System.out);
                player.getGameStatus().print(System.out);

            }
            ch = (char) System.in.read();

        }
    }

    private static void printUsage() {
        System.out.println("Minedodger");
        System.out.println("Instructions ...");
        for (Move m : Move.values()) {
            System.out.println(m.getKey() + " " + m.getDescription());
        }

        System.out.println("Or Q to quit");
    }
}
