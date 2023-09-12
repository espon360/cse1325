import java.util.ArrayList;
import java.time.LocalDate;

public class Library
{
        private String name = "An's Library";
        private ArrayList<Publication> publication;

        public Library(String name)
        {
                this.name = name;
        }

        public Publication addPublication(Publication publication)
        {
                this.publication.add((Publication)(publication));
        }


}
