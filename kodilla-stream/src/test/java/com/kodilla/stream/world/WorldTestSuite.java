package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");
        Continent asia = new Continent("Asia");
        Continent australia = new Continent("Australia");

        Country poland = new Country("Poland");
        Country hungary = new Country("Hungary");
        Country montenegro = new Country("Montenegro");
        Country japan = new Country("Japan");
        Country katar = new Country("Katar");
        Country vietnam = new Country("Vietnam");
        Country australiaCountry = new Country("Australia");
        Country fiji = new Country("Fiji");
        Country russia = new Country("Russia");

        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(australia);

        europa.addCountry(poland);
        europa.addCountry(hungary);
        europa.addCountry(montenegro);
        europa.addCountry(russia);

        asia.addCountry(japan);
        asia.addCountry(katar);
        asia.addCountry(vietnam);
        asia.addCountry(russia);

        australia.addCountry(australiaCountry);
        australia.addCountry(fiji);

        //When

        BigDecimal totalPeople = world.getPeopleQuantity();
        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("9000009");
        Assert.assertEquals(totalPeopleExpected, totalPeople);
    }
}