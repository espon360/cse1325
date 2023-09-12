import java.util.ArrayList;
import java.time.LocalDate;

public class Library
{
        private String name = "An's Library\n\n";
        private ArrayList<Publication> publication;

        public Library(String name)
        {
                this.name = name;
        }

        public void addPublication(Publication publication)
        {
                this.publication.add((Publication)(publication));
        }

        public void checkOut(int publicationIndex, String patron)
        {
              this.publication.get(publicationIndex).checkOut(patron);
        }

        public String toString()
        {
                StringBuilder s = new StringBuilder();
                s.append(name);
                for(int i = 0; i < publication.size(); ++i)
                {
                        s.append(i + ") \"");
                        s.append(publication.get(i).title + "\" by " + publication.get(i).author);
                        s.append(", copyrighted in " + publication.get(i).copyright);
                }
                return s.toString();
        }
}
