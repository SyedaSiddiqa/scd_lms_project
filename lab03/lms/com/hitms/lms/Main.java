package com.hitms.lms;

import com.hitms.lms.model.Book;
import com.hitms.lms.service.LibraryService;
import com.hitms.lms.util.LibraryUtils;
import java.time.LocalDate;

/** Driver class exercising the LMS modules. */
public class Main {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        String title = LibraryUtils.formatTitle(" the great gatsby ");
        service.addBook(new Book("978-0743273565", title));
        service.addBook(new Book("978-0451524935", "1984"));
        System.out.println("Books in catalogue: " + service.bookCount());

        LocalDate issued = LocalDate.of(2026, 1, 1);
        System.out.println("Issue '" + title + "': "
                + service.issueBook("978-0743273565", issued));
        System.out.println("Issue again (should fail): "
                + service.issueBook("978-0743273565", issued));

        double fine = service.returnBook("978-0743273565",
                LocalDate.of(2026, 1, 20));
        System.out.println("Returned after "
                + LibraryUtils.daysBetween(issued, LocalDate.of(2026, 1, 20))
                + " days, fine = Rs. " + fine);
    }
}
