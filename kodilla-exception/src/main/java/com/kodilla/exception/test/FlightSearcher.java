package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    private Map<String, Boolean> airportMap = airportCreator();

    private Map<String, Boolean> airportCreator() {
        Map<String, Boolean> airportDataBase = new HashMap<>();
        airportDataBase.put("BER", false);
        airportDataBase.put("MUN", false);
        airportDataBase.put("LON", true);
        airportDataBase.put("PAR", true);
        airportDataBase.put("POZ", true);

        return airportDataBase;
    }

    private boolean findAirport(String airportName) throws RouteNotFoundException {
        if (airportMap.containsKey(airportName)) {
            return airportMap.get(airportName);
        } else {
            throw new RouteNotFoundException("Indicated airport does not exist in our database!");
        }
    }

    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        return findAirport(flight.getArrivalAirport())
                && findAirport(flight.getDepartureAirport());
    }
}