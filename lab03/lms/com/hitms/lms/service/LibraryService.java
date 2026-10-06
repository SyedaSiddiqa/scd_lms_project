package com.hitms.lms.service;

import com.hitms.lms.model.Book;
import com.hitms.lms.util.LibraryUtils;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/** Handles add, issue and return operations for the library. */
public class LibraryService {

    private static final long LOAN_DAYS = 14;
    private static final double FINE_PER_DAY = 10.0;

    private final Map<String, Book> books = new LinkedHashMap<>();
    private final Map<String, LocalDate> issueDates = new LinkedHashMap<>();

    /** Adds a new book to the catalogue; returns false if ISBN exists. */
    public boolean addBook(Book book) {
        if (books.containsKey(book.getIsbn())) {
            return false;
        }
        books.put(book.getIsbn(), book);
        return true;
    }

    /** Issues a book if it exists and is not already issued. */
    public boolean issueBook(String isbn, LocalDate issueDate) {
        Book book = books.get(isbn);
        if (book == null || book.isIssued()) {
            return false;
        }
        book.setIssued(true);
        issueDates.put(isbn, issueDate);
        return true;
    }

    /** Returns a book and gives back the late fine (0 if on time). */
    public double returnBook(String isbn, LocalDate returnDate) {
        Book book = books.get(isbn);
        if (book == null || !book.isIssued()) {
            return -1;
        }
        long daysKept = LibraryUtils.daysBetween(
                issueDates.remove(isbn), returnDate);
        book.setIssued(false);
        long lateDays = Math.max(0, daysKept - LOAN_DAYS);
        return lateDays * FINE_PER_DAY;
    }

    /** Returns the number of books in the catalogue. */
    public int bookCount() {
        return books.size();
    }
}
