// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.
package library;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * A library resource that can be used to check out items for a patron
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Publication {
    public static final int LOAN_PERIOD = 14; // days
    /**
      * Creates a Publication instance.
      *
      * @param title        the title of the publication
      * @param author       the author of the publication
      * @param copyright    the year the publication was copyrighted
      * @since 1.0
      */
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }
    /**
      * Checks a Publication out to a patron and sets the dueDate
      *
      * @param patron      the name of the patron
      * @since             1.0
      */
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    /**
      * Method to set loanedTo and dueDate to null after Publication is returned
      *
      * @since              1.0
      */
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
    @Override
    /**
      * Returns a string with the Publication's information
      *
      * @since            1.0
      */
    public String toString() {
        return "\"" + title + "\" by " + author + ", copyright " + copyright
            + ((loanedTo != null) ? "\n  : loaned to " + loanedTo + " until " + dueDate
                                  : "");
    }
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;
}
