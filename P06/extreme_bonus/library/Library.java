package library;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Library
{
        public Library(String name)
        {
                this.name = name;
                this.publications = new ArrayList<>();
                this.patrons = new ArrayList<>();
        }

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
                        p.append(i + ") " + patrons.get(i).toString());
                }
                return p.toString();
        }

        private String name;
        private ArrayList<Publication> publications;
        private ArrayList<Patron> patrons;
}
