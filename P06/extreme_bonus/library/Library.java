// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Models a library containing publications for books and videos
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Library
{
        /**
          * Creates a Library instance.
          *
          * @param name        the name of the library
          * @since             1.0
          */
        public Library(String name)
        {
                this.name = name;
                this.publications = new ArrayList<>();
                this.patrons = new ArrayList<>();
        }

        /**
          * Creates a Library instance by loading a save file.
          *
          * @param br          the save file to load from
          * @throws IOException when we can't read the file
          * @since             1.0
          */
        public Library(BufferedReader br) throws IOException
        {
                this.name = br.readLine();
                int size = Integer.parseInt(br.readLine());
                ArrayList<Publication> pub = new ArrayList<>();
                String check;
                for(int i = 0; i < size; ++i)
                {
                        check = br.readLine();
                        if(check.equals("Publication"))
                        {
                            pub.add(new Publication(br));
                        }
                        else if(check.equals("Video"))
                        {
                            pub.add(new Video(br));
                        }
                }
                this.publications = pub;
                if(br.readLine().equals("Patrons"))
                {
                    ArrayList<Patron> pat = new ArrayList<>();
                    size = Integer.parseInt(br.readLine());
                    for(int i = 0; i < size; ++i)
                    {
                        pat.add(new Patron(br));
                    }
                    this.patrons = pat;
                }
        }

        /**
          * Saves the Library's data to a text file
          *
          * @param bw          the file you are saving to
          * @throws IOException when we can't write to the file
          * @since             1.0
          */
        public void save(BufferedWriter bw) throws IOException
        {
                bw.write(name + '\n');
                bw.write("" + publications.size() + '\n');
                for(int i = 0; i < publications.size(); ++i)
                {
                        if(publications.get(i) instanceof Publication)
                        {
                            if(publications.get(i) instanceof Video)
                            {
                               bw.write("Video\n");
                               publications.get(i).save(bw);
                            }
                            else
                            {
                               bw.write("Publication\n");
                               publications.get(i).save(bw);
                            }
                        }
                        else if(publications.get(i) instanceof Video)
                        {
                            bw.write("Video\n");
                            publications.get(i).save(bw);
                        }
                }

                bw.write("Patrons\n");
                bw.write("" + patrons.size() + '\n');
                for(int i = 0; i < patrons.size(); ++i)
                {
                        patrons.get(i).save(bw);
                }
        }

        /**
          * Adds a Publication to the Library publications
          *
          * @param publication        the publication being added
          * @since                    1.0
          */
        public void addPublication(Publication publication)
        {
                publications.add(publication);
        }

        /**
          * Adds a Patron to the Library patrons
          *
          * @param patron             the patron being added
          * @since                    1.0
          */
        public void addPatron(Patron patron)
        {
                patrons.add(patron);
        }

        /**
          * Gets the patron in the specified index
          *
          * @param patronIndex        the index of the patron
          * @since                    1.0
          */
        public Patron getPatron(int patronIndex)
        {
                return patrons.get(patronIndex);
        }

        /**
          * Checks out the publication in the specified index
          *
          * @param publicationIndex        the index of the publication being checked out
          * @param patron                  the patron's information
          * @since                         1.0
          */
        public void checkOut(int publicationIndex, Patron patron)
        {
                try{
                    publications.get(publicationIndex).checkOut(patron);
                } catch(IndexOutOfBoundsException e)
                    {
                        System.err.println("Invalid Index: " + e.getMessage());
                    }
        }

        /**
          * Checks in the publication in the specified index
          *
          * @param publicationIndex        the index of the publication being checked in
          * @since                         1.0
          */
        public void checkIn(int publicationIndex)
        {
                try{
                    publications.get(publicationIndex).checkIn();
                } catch(IndexOutOfBoundsException e)
                    {
                        System.err.println("Invalid Index: " + e.getMessage());
                    }
        }

        @Override
        /**
          * Returns a string with the Library's information and it's publications
          *
          * @since                1.0
          */
        public String toString()
        {
                StringBuilder s = new StringBuilder(name + "\n");
                for(int i = 0; i < publications.size(); ++i)
                {
                        s.append(i + ") " + publications.get(i).toString() + "\n");
                }
                return s.toString();
        }

        /**
          * Returns a string with the List of Patrons and their information
          *
          * @since                1.0
          */
        public String patronMenu()
        {
                StringBuilder p = new StringBuilder("List of Patrons\n");
                for(int i = 0; i < patrons.size(); ++i)
                {
                        p.append(i + ") " + patrons.get(i).toString());
                }
                return p.toString();
        }

        private String name;
        private ArrayList<Publication> publications;
        private ArrayList<Patron> patrons;
}
