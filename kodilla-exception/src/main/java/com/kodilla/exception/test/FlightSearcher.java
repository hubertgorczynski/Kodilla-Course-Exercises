package com.kodilla.exception.test;

import java.util.Map;

public class FlightSearcher {

    private Map<String, Boolean> airportMap;

    public FlightSearcher(Map<String, Boolean> airportMap) {
        this.airportMap = airportMap;
    }

    private boolean findAirport(String airportName) throws RouteNotFoundException {
        if (airportMap.containsKey(airportName)) {
            return airportMap.get(airportName);
        } else {
            throw new RouteNotFoundException("Indicated airport: " + airportName + " does not exist in our database!");
        }
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        return findAirport(flight.getArrivalAirport())
                && findAirport(flight.getDepartureAirport());
    }
}