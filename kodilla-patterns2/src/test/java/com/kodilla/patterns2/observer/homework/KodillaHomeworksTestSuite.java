package com.kodilla.patterns2.observer.homework;

import org.junit.Assert;
import org.junit.Test;

public class KodillaHomeworksTestSuite {

    @Test
    public void testUpdateHomeworks() {
        //Given
        Student janKowalski = new Student("Jan Kowalski", KodillaCourses.JAVA_DEVELOPER);
        Student piotrNowak = new Student("Piotr Nowak", KodillaCourses.JAVA_DEVELOPER);
        Student andrzejTomaszewski = new Student("Andrzej Tomaszewski", KodillaCourses.WEB_DEVELOPER);

        Mentor marianUrbanski = new Mentor("Marian Urbanski");
        Mentor karolNowicki = new Mentor("Karol Nowicki");

        janKowalski.registerObserver(marianUrbanski);
        piotrNowak.registerObserver(marianUrbanski);
        andrzejTomaszewski.registerObserver(karolNowicki);

        //When
        janKowalski.addHomework("Patterns - Facade");
        piotrNowak.addHomework("Library - REST API");
        andrzejTomaszewski.addHomework("JavaScript introduction");

        //Then
        Assert.assertEquals(2, marianUrbanski.getUpdateCount());
        Assert.assertEquals(1, karolNowicki.getUpdateCount());
    }
}
