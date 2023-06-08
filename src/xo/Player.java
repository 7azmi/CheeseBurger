package xo;

public abstract class Player {
    protected String marker;

    Player(String marker) {
        this.marker = marker;
    }

    public String getMarker() {
        return this.marker;
    }

    abstract public int getPlayerMove();
}
