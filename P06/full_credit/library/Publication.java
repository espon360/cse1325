package library;

import java.time.LocalDate;

public class Publication{
        public Publication(String title, String author, int copyright)
        {
                this.title = title;
                this.author = author;
                if(copyright < 1900 || copyright > LocalDate.now().getYear())
                    throw new IllegalArgumentException("Invalid copyright year.");
                this.copyright = copyright;
        }

        public void checkOut(String patron)
        {
                loanedTo = patron;
                dueDate = LocalDate.now().plusDays(14);
        }

        public void checkIn()
        {
                loanedTo = null;
                dueDate = null;
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
        private String loanedTo;
        private LocalDate dueDate;
}
