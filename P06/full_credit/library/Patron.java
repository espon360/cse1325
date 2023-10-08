// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Models a Patron which contains information on their name and email
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Patron
{
      /**
        * Creates a Patron instance.
        *
        * @param name         the name of the Patron
        * @param email        the email address of the Patron
        * @since 1.0
        */
        public Patron(String name, String email)
        {
                this.name = name;
                this.email = email;
        }

        /**
          * Creates a Patron instance by loading a save file.
          *
          * @param br          the save file to load from
          * @throws IOException when we can't read the file
          * @since             1.0
          */
        public Patron(BufferedReader br) throws IOException
        {
                this.name = br.readLine();
                this.email = br.readLine();
        }

        /**
          * Saves the Patron's data to a text file
          *
          * @param bw          the file you are saving to
          * @throws IOException when we can't write to the file
          * @since             1.0
          */
        public void save(BufferedWriter bw) throws IOException
        {
                bw.write(name + '\n');
                bw.write(email + '\n');
        }


        @Override
        /**
          * Returns a string with the Patron's information
          *
          * @since               1.0
          */
        public String toString()
        {
                return name + " (" + email + ")";
        }

        private String name;
        private String email;
}
