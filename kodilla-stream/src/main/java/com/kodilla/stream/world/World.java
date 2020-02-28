package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class World {
    private final List<Continent>listOfContinentsOnTheWorld = new ArrayList<>();

    public boolean addContinent(Continent continent){
        return listOfContinentsOnTheWorld.add(continent);
    }

    public BigDecimal getPeopleQuantity(){
        BigDecimal peopleQuantityOnTheWorld = listOfContinentsOnTheWorld.stream()
                .flatMap(continent -> continent.getListOfCountriesOnContinent().stream())
                .distinct()
                .map(Country::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum,country) -> sum.add(country));

        return peopleQuantityOnTheWorld;
    }
}