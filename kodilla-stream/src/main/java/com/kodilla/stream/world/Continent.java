package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String continentName;
    private final List<Country> listOfCountriesOnContinent = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public List<Country> getListOfCountriesOnContinent() {
        return new ArrayList<>(listOfCountriesOnContinent);
    }

    public boolean addCountry(Country country) {
        return listOfCountriesOnContinent.add(country);
    }
}