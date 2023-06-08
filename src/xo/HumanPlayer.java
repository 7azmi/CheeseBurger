package xo;

import java.util.Scanner;

public class HumanPlayer extends Player {
    HumanPlayer(String marker) {
        super(marker);
    }

    @Override
    public int getPlayerMove() {
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }
}
