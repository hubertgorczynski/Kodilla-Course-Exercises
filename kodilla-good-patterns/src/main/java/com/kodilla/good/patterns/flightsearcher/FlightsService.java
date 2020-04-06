package com.kodilla.good.patterns.flightsearcher;

import java.util.*;
import java.util.stream.Collectors;

public class FlightsService {
    private DataBase dataBase;

    public FlightsService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public Set<Flight> availableFlightsFrom(String departureAirport) {
        return dataBase.getAvailableFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .collect(Collectors.toSet());
    }

    public Set<Flight> availableFlightsTo(String arrivalAirport) {
        return dataBase.getAvailableFlights().stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrivalAirport))
                .collect(Collectors.toSet());
    }

    public Set<List<Flight>> availableConnectingFlights(String departureAirport, String arrivalAirport) {
        Set<List<Flight>> setOfFlights = new HashSet<>();

        dataBase.getAvailableFlights().stream()
                .filter(flight -> flight.getDepartureAirport().equals(departureAirport))
                .forEach(flight -> {
                    List <Flight> temporaryBase = dataBase.getAvailableFlights().stream()
                            .filter(temporaryFlight -> (flight.getArrivalAirport().equals(temporaryFlight.getDepartureAirport()) &&
                                    temporaryFlight.getArrivalAirport().equals(arrivalAirport)))
                            .collect(Collectors.toList());

                    if (temporaryBase.size() > 0) {
                        List<Flight> flightsRoute = new ArrayList<>();
                        flightsRoute.add(flight);
                        flightsRoute.addAll(temporaryBase);
                        setOfFlights.add(flightsRoute);
                    }
                });
        return setOfFlights;
    }
}