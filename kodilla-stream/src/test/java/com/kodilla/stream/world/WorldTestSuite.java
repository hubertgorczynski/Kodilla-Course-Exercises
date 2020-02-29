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

        Country poland = new Country("Poland", new BigDecimal("782364345"));
        Country germany = new Country("Germany", new BigDecimal("847593758"));
        Country italy = new Country("Italy", new BigDecimal("427483485"));
        Country china = new Country("China", new BigDecimal("13984735435"));
        Country vietnam = new Country("Vietnam", new BigDecimal("318586943"));
        Country canada = new Country("Canada", new BigDecimal("45546334"));
        Country japan = new Country("Japan", new BigDecimal("34534534534"));
        Country usa = new Country("USA", new BigDecimal("222345215"));

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
        BigDecimal totalPeopleExpected = new BigDecimal("51163190049");
        Assert.assertEquals(totalPeopleExpected, totalPeople);
    }
}