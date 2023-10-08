package library;

import java.util.ArrayList;

public class Library
{
        public Library(String name)
        {
                this.name = name;
                this.publications = new ArrayList<>();
        }

        public void addPublication(Publication publication)
        {
                publications.add(publication);
        }

        public void checkOut(int publicationIndex, String patron)
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
                StringBuilder s = new StringBuilder(name);
                for(int i = 0; i < publications.size(); ++i)
                {
                        s.append(i + ") " + publications.get(i).toString() + "\n");
                }
                return s.toString();
        }

        private String name;
        private ArrayList<Publication> publications;
}
