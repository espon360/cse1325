package library;
import library.Publication;
import java.time.LocalDate;
import java.time.Duration;
import java.lang.ArithmeticException;

/**
 * A library video that can be checkout by a patron
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Video extends Publication
{
        private Duration runtime;
        /**
          * Creates a Video instance.
          *
          * @param title        the title of the movie
          * @param author       the main director of the movie
          * @param copyright    the year the movie came out / copyrighted
          * @param runtime      the duration of the video in minutes
          * @since 1.0
          */
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
        /**
          * Returns a string with the Video's information
          *
          * @since               1.0
          */
        public String toString()
        {
                StringBuilder vid = new StringBuilder();
                vid.append("Video: " + super.toString() + ", runtime ");
                vid.append(runtime.toMinutes() + " minutes");
                return vid.toString();
        }
}
