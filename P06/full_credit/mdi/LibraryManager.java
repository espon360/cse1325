package mdi;

import library.Library;
import library.Publication;
import library.Video;
import library.Patron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;


public class LibraryManager
{
        private Library library;
        public LibraryManager(Library library)
        {
                this.library = library;
        }

        public void listPublications()
        {
                System.out.println("          Library Catalogue\n____________________\n");
                System.out.println(library);
        }

        public void addPublication()
        {
                String book = System.console().readLine("Please enter the book name: ");
                String writer = System.console().readLine("Please enter the author's name: ");
                int year;
                while(true)
                {
                        try
                        {
                            String cyear = System.console().readLine("Please enter the copyright year: ");
                            year = Integer.parseInt(cyear);
                            break;
                        } catch (IllegalArgumentException e) {System.err.println(e.getMessage());}
                }
                try {library.addPublication(new Publication(book, writer, year));
                } catch (Exception e) {System.err.println("Unable to add publication.");}
                System.out.println("Here's the new library:\n" + library);
        }

        public void addVideo()
        {
                String video = System.console().readLine("Please enter the video name: ");
                String director = System.console().readLine("Please enter the director's name: ");
                int year = 0;
                while(true)
                {
                        try
                        {
                            String cyear = System.console().readLine("Please enter the release year: ");
                            year = Integer.parseInt(cyear);
                            break;
                        } catch (IllegalArgumentException e) {System.err.println(e.getMessage());}
                }

                int run = 0;
                while(true)
                {
                        try
                        {
                            String crun = System.console().readLine("Please enter the runtime in minutes: ");
                            run = Integer.parseInt(crun);
                            Video vid = new Video(video, director, year, run);
                            break;
                        } catch (Video.InvalidRuntimeException e) {System.err.println(e.getMessage());}
                          catch (Exception f) {System.err.println("That is an invalid entry, please input an integer runtime.");}
                }
                System.out.println("Here's the new library:\n" + library);
        }

        public void listPatrons()
        {
                System.out.println(library.patronMenu());
        }

        public void addPatron()
        {
                String name = System.console().readLine("Please enter your name: ");
                String email = System.console().readLine("Please enter your email: ");
                Patron patron = new Patron(name, email);
        }

        public static void main(String[] args)
        {

        }
}
