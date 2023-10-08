package mdi;

import library.Library;
import library.Publication;
import library.Video;
import library.Patron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class LibraryManager
{
        private Library library;
        private static final String name = "An's Library";

        public LibraryManager(Library library)
        {
                this.library = library;
        }

        public void listPublications()
        {
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
                System.out.println("Here's the new library:\n\n" + library);
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
                            library.addPublication(new Video(video, director, year, run));
                            break;
                        } catch (Video.InvalidRuntimeException e) {System.err.println(e.getMessage());}
                          catch (Exception f) {System.err.println("That is an invalid entry, please input an integer runtime.");}
                }
                System.out.println("Here's the new library:\n\n" + library);
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
                library.addPatron(patron);
                System.out.println("This is the updated patron list: \n\n" + library.patronMenu());
        }

        public void checkOutPublication()
        {
                System.out.println(library + "\n" + library.patronMenu());
                String choice;
                int patronIndex;
                int publicationIndex;
                while(true)
                {
                        try
                        {
                                choice = System.console().readLine("Please select the patron (enter the number corresponding with the patron): ");
                                patronIndex = Integer.parseInt(choice);
                                choice = System.console().readLine("Please select the item to checkout (enter the number corresponding with the item): ");
                                publicationIndex = Integer.parseInt(choice);
                                library.checkOut(publicationIndex, library.getPatron(patronIndex));
                                break;
                        } catch (Exception e) {System.err.println("The selected patron or publication was invalid.");}
                }
                System.out.println("Here's the new library:\n\n" + library);
        }

        public void checkInPublication()
        {
                System.out.println(library);
                String choice;
                int publicationIndex;
                while(true)
                {
                        try
                        {
                                choice = System.console().readLine("Please select the publication you'd like to check in (enter the number corresponding with the patron): ");
                                publicationIndex = Integer.parseInt(choice);
                                library.checkIn(publicationIndex);
                                break;
                        } catch (Exception e) {System.err.println("The selected publication was invalid.");}
                }
                System.out.println("Here's the new library:\n\n" + library);
        }

        public void saveLibrary()
        {
                String fileName = System.console().readLine("Please enter the file name you'd like to save to: ");
                try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName)))
                {
                        library.save(bw);
                } catch (Exception e) {System.err.println("Failed to write: " + e);}
        }

        public void openLibrary()
        {
                String fileName = System.console().readLine("Please enter the file name you'd like to load from: ");
                try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
                {
                          Library load = new Library(br);
                          library = load;
                } catch (Exception e) {System.err.println("Failed to read: " + e);}
        }

        public static void clearConsole()
        {
                System.out.print("\033[H\033[2J");
                System.out.flush();
        }

        public static void main(String[] args)
        {
                LibraryManager lm = new LibraryManager(new Library(name));

                StringBuilder menu = new StringBuilder();
                menu.append("\nPlease choose which action you'd like to take from the following menu:\n");
                menu.append("(Enter an integer as your input)\n\n");
                menu.append("0) Exit\n");
                menu.append("1) List all Publications and Videos.\n");
                menu.append("2) Add a new Publication to the library.\n");
                menu.append("3) Add a new Video to the library.\n");
                menu.append("4) List all Patrons.\n");
                menu.append("5) Add a new patron to the patron list.\n");
                menu.append("6) Check out a Publication or Video.\n");
                menu.append("7) Check in a Publication or Video.\n");
                menu.append("8) Save library to file.\n");
                menu.append("9) Load library from file. (There is already a default library named \"save.txt\" you may load)\n");

                clearConsole();

                while(true)
                {
                    try
                      {
                        System.out.println("          Library Catalogue\n__________________________________________\n");
                        System.out.println(name + "\n" + menu.toString());
                        int selection = Integer.parseInt(System.console().readLine("Please select an action to take: "));

                        switch(selection)
                        {
                            case 0:
                            System.out.println("Good bye!\n");
                            System.exit(selection);

                            case 1:
                            clearConsole();
                            lm.listPublications();
                            break;

                            case 2:
                            lm.addPublication();
                            break;

                            case 3:
                            lm.addVideo();
                            break;

                            case 4:
                            clearConsole();
                            lm.listPatrons();
                            break;

                            case 5:
                            lm.addPatron();
                            break;

                            case 6:
                            lm.checkOutPublication();
                            break;

                            case 7:
                            lm.checkInPublication();
                            break;

                            case 8:
                            lm.saveLibrary();
                            break;

                            case 9:
                            lm.openLibrary();
                            break;

                            default:
                            throw new RuntimeException("Invalid: " + selection);
                        }
                      } catch (Exception e) {System.err.println(e.getMessage());}
                }
       }
}
