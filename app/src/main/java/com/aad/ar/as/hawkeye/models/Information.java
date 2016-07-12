package com.aad.ar.as.hawkeye.models;

/**
 * Created by cirmac3 on 7/12/16.
 */
public class Information {
    private String infoName;
    private String infoAddress;
    private String infoDistance;

    public Information(String infoName,String infoAddress,String infoDistance)
    {
        this.infoName=infoName;
        this.infoAddress=infoAddress;
        this.infoDistance=infoDistance;
    }

    public String getInfoName()
    {
        return infoName;
    }

    public String getInfoAddress()
    {
        return infoAddress;
    }

    public String getInfoDistance()
    {
        return infoDistance;
    }

}
