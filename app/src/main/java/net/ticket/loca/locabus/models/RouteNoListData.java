package net.ticket.loca.locabus.models;


public class RouteNoListData {




    private String route_masterid,route_no,route_from_id,route_from_name,route_to_id,route_to_name,is_down_route,bus_type,
    route_from_mname,route_to_mname,route_via,fare,chilfare,trip_km,via_route_no;

    public String getRoute_masterid() {
        return route_masterid;
    }

    public void setRoute_masterid(String route_masterid) {
        this.route_masterid = route_masterid;
    }

    public String getRoute_from_id() {
        return route_from_id;
    }

    public void setRoute_from_id(String route_from_id) {
        this.route_from_id = route_from_id;
    }

    public String getRoute_from_name() {
        return route_from_name;
    }

    public void setRoute_from_name(String route_from_name) {
        this.route_from_name = route_from_name;
    }

    public String getRoute_to_id() {
        return route_to_id;
    }

    public void setRoute_to_id(String route_to_id) {
        this.route_to_id = route_to_id;
    }

    public String getRoute_to_name() {
        return route_to_name;
    }

    public void setRoute_to_name(String route_to_name) {
        this.route_to_name = route_to_name;
    }

    public String getIs_down_route() {
        return is_down_route;
    }

    public void setIs_down_route(String is_down_route) {
        this.is_down_route = is_down_route;
    }

    public String getBus_type() {
        return bus_type;
    }

    public void setBus_type(String bus_type) {
        this.bus_type = bus_type;
    }

    public String getRoute_from_mname() {
        return route_from_mname;
    }

    public void setRoute_from_mname(String route_from_mname) {
        this.route_from_mname = route_from_mname;
    }

    public String getRoute_to_mname() {
        return route_to_mname;
    }

    public void setRoute_to_mname(String route_to_mname) {
        this.route_to_mname = route_to_mname;
    }

    public String getRoute_no() {
        return route_no;
    }

    public void setRoute_no(String route_no) {
        this.route_no = route_no;
    }


    public String getRoute_via() {
        return route_via;
    }

    public void setRoute_via(String route_via) {
        this.route_via = route_via;
    }

    public String getTrip_km() {
        return trip_km;
    }

    public void setTrip_km(String trip_km) {
        this.trip_km = trip_km;
    }

    public String getChilfare() {
        return chilfare;
    }

    public void setChilfare(String chilfare) {
        this.chilfare = chilfare;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getVia_route_no() {
        return via_route_no;
    }

    public void setVia_route_no(String via_route_no) {
        this.via_route_no = via_route_no;
    }
}
