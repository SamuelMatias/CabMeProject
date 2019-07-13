package org.academiadecodigo.codezillas.tripManager;

public enum Location {
    RAMINHO(0,0),
    QUATRO_RIBEIRAS(0,1),
    LAJES(0,2),
    STA_BARBARA(0,1),
    ANGRA(1,1),
    S_SEBASTIAO(1,2);

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    private int x;
    private int y;

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
