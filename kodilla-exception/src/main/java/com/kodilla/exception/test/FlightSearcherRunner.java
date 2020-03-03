package com.kodilla.exception.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FlightSearcherRunner {

    public static void main(String[] args) {

        Map<String, Boolean> airportDataBase = new HashMap<>();
        airportDataBase.put("BER", false);
        airportDataBase.put("MUN", false);
        airportDataBase.put("LON", true);
        airportDataBase.put("PAR", true);
        airportDataBase.put("POZ", true);

        FlightSearcher flightSearcher = new FlightSearcher(airportDataBase);

        Flight berlinLondon = new Flight("BER", "LON");
        Flight poznanMunich = new Flight("POZ", "MUN");
        Flight parisInowroclaw = new Flight("PAR", "INO");
        Flight londonParis = new Flight("LON", "PAR");

        ArrayList<Flight> flightList = new ArrayList<>();
        flightList.add(berlinLondon);
        flightList.add(poznanMunich);
        flightList.add(parisInowroclaw);
        flightList.add(londonParis);

        for (Flight theFlight : flightList) {
            try {
                boolean existFlight = flightSearcher.findFlight(theFlight);
                System.out.println("Possibility of flight from " + theFlight.getDepartureAirport() + " to "
                        + theFlight.getArrivalAirport() + " : " + existFlight);
            } catch (RouteNotFoundException e) {
                System.out.println(e + " Please input correct airport name.");
            }
        }
    }
}
