package org.academiadecodigo.codezillas.user;

import org.academiadecodigo.codezillas.tripManager.Location;

public class ClientFactory {

    private static int id=0;

    public static Client getNewClient(){
        id++;
        return new Client(id,"Client"+id, Location.ANGRA,Location.STA_BARBARA);

    }

}
