package library;

import java.util.ArrayList;

public class Library
{
        public Library(String name)
        {
                this.name = name;
                this.publications = new ArrayList<>();
                this.patrons = new ArrayList<>();
        }

        public void addPublication(Publication publication)
        {
                publications.add(publication);
        }

        public void addPatron(Patron patron)
        {
                patrons.add(patron);
        }

        public Patron getPatron(int patronIndex)
        {
                return patrons.get(patronIndex);
        }

        public void checkOut(int publicationIndex, Patron patron)
        {
                try{
                    publications.get(publicationIndex).checkOut(patron);
                } catch(IndexOutOfBoundsException e)
                    {
                        System.err.println("Invalid Index: " + e.getMessage());
                    }
        }

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
        public String toString()
        {
                StringBuilder s = new StringBuilder(name + "\n");
                for(int i = 0; i < publications.size(); ++i)
                {
                        s.append(i + ") " + publications.get(i).toString() + "\n");
                }
                return s.toString();
        }

        public String patronMenu()
        {
                StringBuilder p = new StringBuilder("List of Patrons\n");
                for(int i = 0; i < patrons.size(); ++i)
                {
                        p.append(i + ") " + patrons.get(i).toString() + "\n");
                }
                return p.toString();
        }

        private String name;
        private ArrayList<Publication> publications;
        private ArrayList<Patron> patrons;
}
