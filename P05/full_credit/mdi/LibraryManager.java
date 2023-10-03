// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

package mdi;

import library.Library;
import library.Publication;
import library.Video;

public class LibraryManager {
    public static void main(String[] args) {
        Library library = new Library("The Library at Alexandria (Texas)");
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));

        StringBuilder menu = new StringBuilder();
        menu.append("Greetings and Welcome to The Library at Alexandria (Texas)");
        menu.append(", please choose which \naction you'd like to take from the following menu:\n");
        menu.append("(Enter an integer as your input)\n\n");
        menu.append("0) Exit\n");
        menu.append("1) List all Publications and Videos.\n");
        menu.append("2) Add a new Publication to the library.\n");
        menu.append("3) Add a new Video to the library.\n");
        menu.append("4) Check out a Publication or Video.\n");
        menu.append("5) Check in a Publication or Video.\n");

        System.out.println(menu);
        int selection;

        //while(true)
        //{
                //try
                //{
                    String selectionInput = System.console().readLine("Please select an action: ");
                    selection = Integer.parseInt(selectionInput);

                    switch(selection)
                    {
                      case 0:
                        System.out.println("Good bye!\n");
                        System.exit(selection);
                      case 1:
                        System.out.println(library);
                        break;
                      case 2:
                        String book = System.console().readLine("Please enter the book name: ");
                        String writer = System.console().readLine("Please enter the author's name: ");
                        int year = Integer.parseInt("Please enter the copyright year: ");
                        library.addPublication(new Publication(book, writer, year));
                    }
                //}
        //}

    }
}
