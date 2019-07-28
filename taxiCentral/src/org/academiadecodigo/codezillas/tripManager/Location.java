package org.academiadecodigo.codezillas.tripManager;

public enum Location {
    ANGRA(1,1),
    LAJES(0,2),
    STA_BARBARA(0,1),
    RAMINHO(0,0),
    S_SEBASTIAO(1,2),
    QUATRO_RIBEIRAS(0,1);

    Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
