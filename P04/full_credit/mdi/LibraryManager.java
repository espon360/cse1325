// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.
package mdi;

import library.*;

public class LibraryManager {
    public static void main(String[] args) {
        try {
            Library library = new Library("An's Library");
            library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
            library.addPublication(new Publication("The Firm", "John Grisham", 1992));
            library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
            library.addPublication(new Video("The Dark Knight", "Christopher Nolan", 2008, 152));
            library.addPublication(new Video("Spider-Man: Into the Spiderverse", "Bob Persichetti", 2018, 117));
            library.addPublication(new Video("Oppenheimer", "Christopher Nolan", 2023, 180));
            System.out.println(library);
            int selection = Integer.parseInt(System.console().readLine("\nWhich item to check out? "));
            String patron = System.console().readLine("Who are you? ");
            library.checkOut(selection, patron);
            System.out.println(library);
        } catch(Exception e) {
            System.err.println("Unable to check out a publication\n" + e);
        }
    }
}
