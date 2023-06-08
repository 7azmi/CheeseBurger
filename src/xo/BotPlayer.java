package xo;

public class BotPlayer extends Player {
    BotPlayer(String marker) {
        super(marker);
    }

    @Override
    public int getPlayerMove() {
        return (int) (Math.random() * 9 + 1);
    }
}
