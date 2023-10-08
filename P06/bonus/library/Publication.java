// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * A library resource that can be used to check out items for a patron
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Publication{

        /**
          * Creates a Publication instance.
          *
          * @param title        the title of the publication
          * @param author       the author of the publication
          * @param copyright    the year the publication was copyrighted
          * @throws IllegalArgumentException when copyright is older than 100 years or in the future
          * @since 1.0
          */
        public Publication(String title, String author, int copyright)
        {
                this.title = title;
                this.author = author;
                if(copyright < 1900 || copyright > LocalDate.now().getYear())
                    throw new IllegalArgumentException("Invalid copyright year: " + copyright);
                this.copyright = copyright;
        }

        /**
          * Creates a Publication instance by loading a save file.
          *
          * @param br           the save file to load from
          * @throws IOException when we can't read the file
          * @since 1.0
          */
        public Publication(BufferedReader br) throws IOException
        {
                this.title = br.readLine();
                this.author = br.readLine();
                this.copyright = Integer.parseInt(br.readLine());
                if(br.readLine().equals("Checked in"))
                {
                    this.loanedTo = null;
                    this.dueDate = null;
                }
                else
                {
                    this.loanedTo = new Patron(br);
                    LocalDate date = LocalDate.parse(br.readLine());
                    this.dueDate = date;
                }
        }

        /**
          * Checks a Publication out to a patron and sets the dueDate or informs the user the item is already checked out.
          *
          * @param patron      an object that contains the patron's name and email
          * @since             1.0
          */
        public void checkOut(Patron patron)
        {
                if(loanedTo == null)
                {
                    loanedTo = patron;
                    dueDate = LocalDate.now().plusDays(14);
                }
                else
                {
                    System.out.println("I'm sorry, but that item has already been checked out.\n");
                }
        }

        /**
          * Checks a Publication in
          *
          * @since             1.0
          */
        public void checkIn()
        {
                loanedTo = null;
                dueDate = null;
        }

        /**
          * Saves the Publication's data to a text file
          *
          * @param bw          the file you are saving to
          * @throws IOException when we can't write to the file
          * @since             1.0
          */
        public void save(BufferedWriter bw) throws IOException
        {
                bw.write(title + '\n');
                bw.write(author + '\n');
                bw.write("" + copyright + '\n');
                if(loanedTo == null)
                    bw.write("Checked in\n");
                else
                {
                    bw.write("Checked out\n");
                    loanedTo.save(bw);
                    bw.write("" + dueDate.toString() + '\n');
                }
        }

        /**
          * Creates a StringBuilder that formats the Publication
          *
          * @param pre         indicates what type of publication the item is
          * @param tail        a special modifier to the format of the publication depending on the type of publication
          * @since             1.0
          */
        protected StringBuilder toStringBuilder(String pre, String tail)
        {
                StringBuilder s = new StringBuilder(pre + "\"" + title + "\" ");
                s.append("by: " + author + ", copyrighted in " + copyright + tail + ".");
                if(loanedTo != null)
                    s.append("\n   loaned to: " + loanedTo + " and is due on " + dueDate + ".");
                return s;
        }

        @Override
        /**
          * Returns a String with the Publications information formatted via the toStringBuilder method
          *
          * @since             1.0
          */
        public String toString()
        {
                return toStringBuilder("Book - ", "").toString();
        }

        private String title;
        private String author;
        private int copyright;
        private Patron loanedTo;
        private LocalDate dueDate;
}
