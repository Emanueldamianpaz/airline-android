package com.davinci.edu.airline_android.infraestructure.models;

import java.util.List;

public class Airline {

    private List<Flight> flightList;

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }
}
