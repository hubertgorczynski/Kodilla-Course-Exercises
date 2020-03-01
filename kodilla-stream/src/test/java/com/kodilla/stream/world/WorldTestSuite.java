package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();

        Continent europa = new Continent("Europa");
        Continent asia = new Continent("Asia");
        Continent northAmerica = new Continent("North America");

        Country poland = new Country("Poland", new BigDecimal("80000000000000000000"));
        Country germany = new Country("Germany", new BigDecimal("83000000000000000000"));
        Country italy = new Country("Italy", new BigDecimal("80000000000000000000"));
        Country china = new Country("China", new BigDecimal("93800600000000000000"));
        Country vietnam = new Country("Vietnam", new BigDecimal("95000000000000000000"));
        Country canada = new Country("Canada", new BigDecimal("98000000000000000000"));
        Country japan = new Country("Japan", new BigDecimal("61260000000000000000"));
        Country usa = new Country("USA", new BigDecimal("92700000000000000000"));

        world.addContinent(europa);
        world.addContinent(asia);
        world.addContinent(northAmerica);

        europa.addCountry(poland);
        europa.addCountry(germany);
        europa.addCountry(italy);

        asia.addCountry(japan);
        asia.addCountry(china);
        asia.addCountry(vietnam);

        northAmerica.addCountry(usa);
        northAmerica.addCountry(canada);

        //When
        BigDecimal totalPeople = world.getPeopleQuantity();

        //Then
        BigDecimal totalPeopleExpected = new BigDecimal("683760600000000000000");
        Assert.assertEquals(totalPeopleExpected, totalPeople);
    }
}