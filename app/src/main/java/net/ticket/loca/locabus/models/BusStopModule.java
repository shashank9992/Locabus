package net.ticket.loca.locabus.models;

public class BusStopModule {

    private String FromLocationMarathi,ToLocationMarathi,FromLocationEnglish,ToLocationEnglish,
    RouteNumber,StopMasterId,BusType;

    private boolean isSourceSelected,isDestinationSelected;

    public String getFromLocationMarathi() {
        return FromLocationMarathi;
    }

    public void setFromLocationMarathi(String fromLocationMarathi) {
        FromLocationMarathi = fromLocationMarathi;
    }

    public String getToLocationMarathi() {
        return ToLocationMarathi;
    }

    public void setToLocationMarathi(String toLocationMarathi) {
        ToLocationMarathi = toLocationMarathi;
    }

    public String getFromLocationEnglish() {
        return FromLocationEnglish;
    }

    public void setFromLocationEnglish(String fromLocationEnglish) {
        FromLocationEnglish = fromLocationEnglish;
    }

    public String getToLocationEnglish() {
        return ToLocationEnglish;
    }

    public void setToLocationEnglish(String toLocationEnglish) {
        ToLocationEnglish = toLocationEnglish;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        BusType = busType;
    }

    public String getStopMasterId() {
        return StopMasterId;
    }

    public void setStopMasterId(String stopMasterId) {
        StopMasterId = stopMasterId;
    }

    public String getRouteNumber() {
        return RouteNumber;
    }

    public void setRouteNumber(String routeNumber) {
        RouteNumber = routeNumber;
    }

    public boolean isDestinationSelected() {
        return isDestinationSelected;
    }

    public void setDestinationSelected(boolean destinationSelected) {
        isDestinationSelected = destinationSelected;
    }

    public boolean isSourceSelected() {
        return isSourceSelected;
    }

    public void setSourceSelected(boolean sourceSelected) {
        isSourceSelected = sourceSelected;
    }
}
