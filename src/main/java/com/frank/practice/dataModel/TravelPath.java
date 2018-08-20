package com.frank.practice.dataModel;

public class TravelPath {
    public String location;
    public TravelPath next;
    public TravelPath() {
    }

    public TravelPath(String location) {
        this.location = location;
    }

    public TravelPath(String location, TravelPath next) {
        this.location = location;
        this.next = next;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public TravelPath getNext() {
        return next;
    }

    public void setNext(TravelPath next) {
        this.next = next;
    }
}
