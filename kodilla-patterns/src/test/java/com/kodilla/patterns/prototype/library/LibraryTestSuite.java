package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        //Given
        Library library = new Library("Library - the original");
        Book book1 = new Book("Harry Potter", "J.K. Rowling ", LocalDate.of(2012, Month.SEPTEMBER, 25));
        Book book2 = new Book("The Da Vinci Code", "Dan Brown", LocalDate.of(2002, Month.JUNE, 11));
        Book book3 = new Book("The Witcher", "Andrzej Sapkowski", LocalDate.of(2001, Month.DECEMBER, 7));
        Book book4 = new Book("Lord of the Rings", "J.R.R. Tolkien", LocalDate.of(1997, Month.FEBRUARY, 17));

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        //making a shallow copy of object library
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("Library - shallow copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //making a deep copy of object library
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("Library - deep copy");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //When
        library.removeBook(book2);

        //Then
        System.out.println(library);
        System.out.println(clonedLibrary);
        System.out.println(deepClonedLibrary);
        Assert.assertEquals(3, library.getBooks().size());
        Assert.assertEquals(3, clonedLibrary.getBooks().size());
        Assert.assertEquals(4, deepClonedLibrary.getBooks().size());
        Assert.assertEquals(clonedLibrary.getBooks(), library.getBooks());
        Assert.assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());
    }
}