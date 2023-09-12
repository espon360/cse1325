import java.util.ArrayList;
import java.time.LocalDate;

public class Publication
{
        private String title;
        private String author;
        private int copyright; // the year it is copyrighted in
        private String loanedTo; // patron who checked book
        private LocalDate dueDate; // when is book due (14 days after today)

        public Publication(String title, String author, int copyright)
        {
                this.title = title;
                this.author = author;
                LocalDate d = LocalDate.now();
                int year = d.getYear();
                if(copyright < 1900 || copyright > year)
                        throw new IllegalArgumentException("Copyright year older than 1900 or set in the future");
                else this.copyright = copyright;
        }

        public LocalDate checkOut(String patron)
        {
                this.loanedTo = patron;
                LocalDate d = LocalDate.now();
                this.dueDate = d.plusWeeks(2);

                return this.dueDate;
        }

        public String toString()
        {
                return loanedTo + " checked out \'" + title + "\' by "
                + author + "\n Copyrighted: " + copyright + "\n Please return by: "
                + dueDate;
        }
}
