package net.ticket.loca.locabus.models;

public class StopListData {

    private String stop_name_english,stop_type,stop_desc;
    private int stop_id;

    public String getStop_name_english() {
        return stop_name_english;
    }

    public void setStop_name_english(String stop_name_english) {
        this.stop_name_english = stop_name_english;
    }

    public String getStop_type() {
        return stop_type;
    }

    public void setStop_type(String stop_type) {
        this.stop_type = stop_type;
    }

    public int getStop_id() {
        return stop_id;
    }

    public void setStop_id(int stop_id) {
        this.stop_id = stop_id;
    }

    public String getStop_desc() {
        return stop_desc;
    }

    public void setStop_desc(String stop_desc) {
        this.stop_desc = stop_desc;
    }
}
