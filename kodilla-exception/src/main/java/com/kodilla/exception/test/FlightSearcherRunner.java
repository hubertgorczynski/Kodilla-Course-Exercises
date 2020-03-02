package com.kodilla.exception.test;

public class FlightSearcherRunner {

    public static void main(String[] args) {
        Flight berlinLondon = new Flight("BER", "LON");
        Flight poznanMunich = new Flight("POZ", "MUN");
        Flight parisInowroclaw = new Flight("PAR", "INO");
        Flight londonParis = new Flight("LON", "PAR");

        FlightSearcher flightSearcher = new FlightSearcher();

        try {
            boolean existBerlinLondon = flightSearcher.findFlight(berlinLondon);
            System.out.println("Possibility of flight Berlin - London: " + existBerlinLondon);
        } catch (RouteNotFoundException e) {
            System.out.println(e + " Please input correct airport name.");
        }

        try {
            boolean existPoznanMunich = flightSearcher.findFlight(poznanMunich);
            System.out.println("Possibility of flight Poznan - Munich: " + existPoznanMunich);
        } catch (RouteNotFoundException e) {
            System.out.println(e + " Please input correct airport name.");
        }

        try {
            boolean existParisInowroclaw = flightSearcher.findFlight(parisInowroclaw);
            System.out.println("Possibility of flight Paris - Inowroclaw: " + existParisInowroclaw);
        } catch (RouteNotFoundException e) {
            System.out.println(e + " Please input correct airport name.");
        }

        try {
            boolean existLondonParis = flightSearcher.findFlight(londonParis);
            System.out.println("Possibility of flight London - Paris: " + existLondonParis);
        } catch (RouteNotFoundException e) {
            System.out.println(e + " Please input correct airport name.");
        }
    }
}
