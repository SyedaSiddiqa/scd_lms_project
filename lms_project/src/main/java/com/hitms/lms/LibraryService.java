package com.hitms.lms;

import java.util.List;

/** Handles issue and return operations for the library. */
public class LibraryService {

    /**
     * Returns the copy count after issuing one copy of title.
     * @throws BookUnavailableException if availableCopies is 0.
     */
    public static int issueBook(int availableCopies, String title) throws BookUnavailableException {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Book title must not be empty.");
        }
        if (availableCopies <= 0) {
            throw new BookUnavailableException("'" + title + "' has no copies available.");
        }
        return availableCopies - 1;
    }

    /** Returns the copy count after one copy is returned. */
    public static int returnBook(int availableCopies) {
        return availableCopies + 1;
    }

    /** Returns the member ID if it exists in the list, otherwise null. */
    public static String findMemberById(List<String> members, String id) {
        for (String member : members) {
            if (member.equals(id)) {
                return member;
            }
        }
        return null;
    }
}
