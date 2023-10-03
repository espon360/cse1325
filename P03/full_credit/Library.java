import java.util.ArrayList;
import java.time.LocalDate;

public class Library
{
        private String name;
        private ArrayList<Publication> publications;

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
              publications.get(publicationIndex).checkOut(patron);
        }

        public String toString()
        {
                StringBuilder s = new StringBuilder();
                s.append(name);
                for(int i = 0; i < publications.size(); ++i)
                {
                        s.append(i + ") \"");
                        s.append(publications.get(i).toString() + "\n");
                }
                return s.toString();
        }
}
