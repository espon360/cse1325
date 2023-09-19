package library;
import library.Publication;
import java.time.LocalDate;
import java.time.Duration;
import java.lang.ArithmeticException;

public class Video extends Publication
{
        private Duration runtime;
        public Video(String title, String author, int copyright, int runtime)
        {
                super(title, author, copyright);
                if(runtime <= 0)
                {
                        throw new ArithmeticException(title + "has invalid runtime "
                        + runtime);
                }
                this.runtime = Duration.ofMinutes(runtime);
        }

        @Override
        public String toString()
        {
                StringBuilder vid = new StringBuilder();
                vid.append("Video: " + super.toString() + ", runtime ");
                vid.append(runtime.toMinutes() + " minutes");
                return vid.toString();
        }
}
