package net.ticket.loca.locabus.models;

/**
 * Created by user on 6/17/2017.
 */

public class BusList
{
    private String bus_stop_name,stop_lat,stop_lang,id,bust_stop_name_marathi,bus_stop_type;

    public String getStop_lang() {
        return stop_lang;
    }

    public void setStop_lang(String stop_lang) {
        this.stop_lang = stop_lang;
    }

    public String getStop_lat() {
        return stop_lat;
    }

    public void setStop_lat(String stop_lat) {
        this.stop_lat = stop_lat;
    }

    public String getBus_stop_name() {
        return bus_stop_name;
    }

    public void setBus_stop_name(String bus_stop_name) {
        this.bus_stop_name = bus_stop_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBust_stop_name_marathi() {
        return bust_stop_name_marathi;
    }

    public void setBust_stop_name_marathi(String bust_stop_name_marathi) {
        this.bust_stop_name_marathi = bust_stop_name_marathi;
    }



    public String getBus_stop_type() {
        return bus_stop_type;
    }

    public void setBus_stop_type(String bus_stop_type) {
        this.bus_stop_type = bus_stop_type;
    }
}
