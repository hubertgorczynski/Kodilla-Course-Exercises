package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("Sesame seed bun")
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Bacon")
                .ingredient("Pickles")
                .ingredient("Onion")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();
        int howManyBurgers = bigmac.getBurgers();
        String whichSauce = bigmac.getSauce();
        String bunType = bigmac.getBun();
        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(2, howManyBurgers);
        Assert.assertEquals("Barbecue", whichSauce);
        Assert.assertTrue(bigmac.getIngredients().contains("Pickles"));
        Assert.assertFalse(bigmac.getIngredients().contains("Mushrooms"));
        Assert.assertNotNull(bunType);
    }
}