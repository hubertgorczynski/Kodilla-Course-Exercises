package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("Adam Mickiewicz", "Pan Tadeusz", 1834, "1"));
        bookSet.add(new Book("Adam Mickiewicz", "Dziady", 1825, "2"));
        bookSet.add(new Book("Juliusz Slowacki", "Kordian", 1833, "3"));
        MedianAdapter medianAdapter = new MedianAdapter();
        //When
        int median = medianAdapter.publicationYearMedian(bookSet);
        //Then
        System.out.println("Median of publication Year: " + median);
        assertEquals(median, 1833);
    }
}
