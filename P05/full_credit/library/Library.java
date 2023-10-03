// Copyright 2023 An Duong <https://github.com/espon360/cse1325.git>
// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.util.ArrayList;

/**
 * Models a library containing various publications.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
 public class Library {
    /**
     * Creates a Library instance.
     *
     * @param name         the name of the library
     * @since              1.0
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }
    /**
     * Adds a publication to this library instance.
     *
     * @param publication  the publication to add to the library
     * @since              1.0
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    /**
     * Checks out a publication from this library instance.
     *
     * The due date will be set to 2 weeks from the current date.
     *
     * @param publicationIndex  the index as shown by toString()
     * @param patron            identification of the borrower
     * @since                   1.0
     */
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex
                + ": " + e.getMessage() + "\n");
        }
    }
    /**
     * Lists all publications in this library instance.
     *
     * The index shown in the resulting String may be used
     * to check out a publication using the checkOut() method.
     *
     * @returns     the string representation of all library publications
     * @since       1.0
     */

     public void checkIn(int publicationIndex)
     {
          try
          {
                  publications.get(publicationIndex).checkIn();
          } catch(Exception e) {
                  System.err.println("\nUnable to check in publication #" + publicationIndex
                                      + ": " + e.getMessage() + "\n");
          }
     }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications;
}
