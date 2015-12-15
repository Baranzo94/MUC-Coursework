package com.gcu.liam.muccoursework;

/**
 * Created by Liam on 08/12/2015.
 */
import java.io.Serializable;

public class carParkData implements Serializable{

    private String carParkIdentity;
    private String carParkOccupancy;


    public carParkData()
    {
        carParkIdentity = "";
        carParkOccupancy = "";
    }

    public String getcarParkIdentity()
    {
        return carParkIdentity;
    }

    public void setcarParkIdentity(String identity)
    {
        carParkIdentity = identity;
    }

    public String getcarParkOccupancy()
    {
        return carParkOccupancy;
    }

    public void setcarParkOccupancy(String occupancy)
    {
        carParkOccupancy = occupancy;
    }

    public String toString()
    {
        String carparkData;


        carparkData = "carParkData [itemTitle = " + carParkIdentity;
        carparkData = ", carParkOccupancy" + carParkOccupancy +"]";

        return carparkData;
    }
}
