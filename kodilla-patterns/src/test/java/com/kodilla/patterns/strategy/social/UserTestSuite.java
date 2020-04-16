package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialMedia.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User marc = new Millenials("Marc");
        User jack = new YGeneration("Jack");
        User sabrina = new ZGeneration("Sabrina");

        //When
        String marcMedia = marc.sharePost();
        String jackMedia = jack.sharePost();
        String sabrinaMedia = sabrina.sharePost();

        //Then
        Assert.assertEquals("Twitter", marcMedia);
        System.out.println(marc.getUserName() + " is addicted to " + marcMedia);
        Assert.assertEquals("Facebook", jackMedia);
        System.out.println(jack.getUserName() + " is addicted to " + jackMedia);
        Assert.assertEquals("Snapchat", sabrinaMedia);
        System.out.println(sabrina.getUserName() + " is addicted to " + sabrinaMedia);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User marc = new Millenials("Marc");

        //When
        System.out.println("Before:");
        String marcMedia = marc.sharePost();
        System.out.println(marc.getUserName() + " was addicted to " + marcMedia);

        System.out.println("Now:");
        marc.setSocialPublisher(new SnapchatPublisher());
        marcMedia = marc.sharePost();
        System.out.println(marc.getUserName() + " is now addicted to " + marcMedia);

        //Then
        Assert.assertEquals("Snapchat", marcMedia);
    }
}