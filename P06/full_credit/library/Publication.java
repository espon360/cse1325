package library;

import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Publication{
        public Publication(String title, String author, int copyright)
        {
                this.title = title;
                this.author = author;
                if(copyright < 1900 || copyright > LocalDate.now().getYear())
                    throw new IllegalArgumentException("Invalid copyright year: " + copyright);
                this.copyright = copyright;
        }

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
                    this.loanedTo = new Patron(br);
                    LocalDate date = LocalDate.parse(br.readLine());
                    this.dueDate = date;
        }

        public void checkOut(Patron patron)
        {
                loanedTo = patron;
                dueDate = LocalDate.now().plusDays(14);
        }

        public void checkIn()
        {
                loanedTo = null;
                dueDate = null;
        }
        
        public void save(BufferedWriter bw) throws IOException
        {
                bw.write(title + '\n');
                bw.write(author + '\n');
                bw.write("" + copyright + '\n');
                if(loanedTo == null)
                    bw.write("Checked in\n");
                else
                    bw.write("Checked out\n");
                    loanedTo.save(bw);
                    bw.write("" + dueDate.toString() + '\n');
        }

        protected StringBuilder toStringBuilder(String pre, String tail)
        {
                StringBuilder s = new StringBuilder(pre + "\"" + title + "\" ");
                s.append("by: " + author + ", copyrighted in " + copyright + tail + ".\n");
                if(loanedTo != null)
                    s.append("   loaned to: " + loanedTo + " and is due on " + dueDate + ".");
                return s;
        }
        @Override
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
