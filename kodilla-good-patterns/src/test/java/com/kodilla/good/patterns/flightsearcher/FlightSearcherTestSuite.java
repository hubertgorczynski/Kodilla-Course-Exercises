package com.kodilla.good.patterns.flightsearcher;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FlightSearcherTestSuite {

    private static FlightsService flightsService;
    private static DataBase dataBaseMock;
    private static Set<Flight> availableFlights;

    @BeforeClass
    public static void beforeClass() {
        dataBaseMock = mock(DataBase.class);
        flightsService = new FlightsService(dataBaseMock);

        availableFlights = new HashSet<>();
        availableFlights.add(new Flight("WRO", "WAR"));
        availableFlights.add(new Flight("WAR", "GDA"));
        availableFlights.add(new Flight("WRO", "NYC"));
        availableFlights.add(new Flight("GDA", "NYC"));
        availableFlights.add(new Flight("WAR", "NYC"));
        availableFlights.add(new Flight("WRO", "GDA"));
    }

    @Test
    public void availableFlightsFromTest() {
        //Given
        String departureAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "WAR"));
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("WRO", "GDA"));
        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void notAvailableFlightsFromTest() {
        //Given
        String departureAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsFrom(departureAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void availableFlightsToTest() {
        //Given
        String arrivalAirport = "NYC";
        Set<Flight> expected = new HashSet<>();
        expected.add(new Flight("WRO", "NYC"));
        expected.add(new Flight("GDA", "NYC"));
        expected.add(new Flight("WAR", "NYC"));
        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void notAvailableFlightsToTest() {
        //Given
        String arrivalAirport = "WRO";
        Set<Flight> expected = new HashSet<>();
        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<Flight> result = flightsService.availableFlightsTo(arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void availableConnectingFlightsTest() {
        //Given
        String departureAirport = "WRO";
        String arrivalAirport = "NYC";
        Set<List<Flight>> expected = new HashSet<>();

        List<Flight> wroWarWarNyc = new ArrayList<>();
        wroWarWarNyc.add(new Flight("WRO", "WAR"));
        wroWarWarNyc.add(new Flight("WAR", "NYC"));

        expected.add(wroWarWarNyc);

        List<Flight> wroGdaGdaNyc = new ArrayList<>();
        wroGdaGdaNyc.add(new Flight("WRO", "GDA"));
        wroGdaGdaNyc.add(new Flight("GDA", "NYC"));

        expected.add(wroGdaGdaNyc);
        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void notAvailableConnectingFlightsTest() {
        //Given
        String departureAirport = "NYC";
        String arrivalAirport = "GDA";
        Set<List<Flight>> expected = new HashSet<>();

        //When
        when(dataBaseMock.getAvailableFlights()).thenReturn(availableFlights);
        Set<List<Flight>> result = flightsService.availableConnectingFlights(departureAirport, arrivalAirport);
        //Then
        Assert.assertEquals(expected, result);
    }
}