

public class LibraryManager
{
        public static void main(String[] args)
        {
                try
                {
                          Library l = new Library("An's Library\n");
                          l.addPublication(new Publication("Book A", "Author A", 2000));
                          l.addPublication(new Publication("Book B", "Author B", 2002));
                          l.addPublication(new Publication("Book B", "Author B", 2004));

                          System.out.println(l);
                          int choice = Integer.parseInt(System.console().readLine("\nWhich book to checkout? "));
                          // parseInt method from class Integer will take a int argument which is read from readLine() method
                          String patron = System.console().readLine("What is your name? ");

                          l.checkOut(choice, patron);
                          System.out.println(l);
                } catch(Exception e) {
                          System.err.println("Unable to checkout a publication\n" + e);
                          // prints error message to System.err with the Exception e
                }
        }
}
