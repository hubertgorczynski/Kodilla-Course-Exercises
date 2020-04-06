package com.kodilla.good.patterns.flightsearcher;

import java.util.Set;

public class DataBase {
    private Set<Flight> availableFlights;

    public DataBase(Set<Flight> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public Set<Flight> getAvailableFlights() {
        return availableFlights;
    }
}