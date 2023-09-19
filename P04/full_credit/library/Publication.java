// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.
package library;

import java.util.ArrayList;
import java.time.LocalDate;

public class Publication {
    public static final int LOAN_PERIOD = 14; // days
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
    @Override
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
