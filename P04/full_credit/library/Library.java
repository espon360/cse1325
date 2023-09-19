// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.
package library;

import library.Publication;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Models a library containing publications for books and videos
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */


public class Library {
    /**
      * Creates a Library instance.
      *
      * @param name        the name of the library
      * @since             1.0
      */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>(); // = new ArrayList<>() may be in field
    }
    /**
      * Adds a Publication to the Library publications
      *
      * @param publication        the publication being added
      * @since                    1.0
      */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    /**
      * Checks out the publication in the specified index
      *
      * @param publicationIndex        the index of the publication being checked out
      * @param patron                  the name of the patron
      * @since                         1.0
      */
    public void checkOut(int publicationIndex, String patron) {
        publications.get(publicationIndex).checkOut(patron);
    }
    @Override
    /**
      * Returns a string with the Library's information and it's publications
      *
      * @since                1.0
      */
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications; // = new ArrayList<>(); // also permissible
}
