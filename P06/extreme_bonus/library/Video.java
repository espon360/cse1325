package library;

import java.time.Duration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Video extends Publication
{
        public class InvalidRuntimeException extends ArithmeticException
        {
                public InvalidRuntimeException(){super();}
                public InvalidRuntimeException(String message){super(message);}
                public InvalidRuntimeException(String title, int runtime) {super(title + " has invalid runtime: " + runtime);}
        }

        public Video(String title, String author, int copyright, int runtime)
        {
                super(title, author, copyright);
                if(runtime < 1)
                    throw new InvalidRuntimeException(title, runtime);
                this.runtime = Duration.ofMinutes(runtime);
        }

        public Video(BufferedReader br) throws IOException
        {
              super(br);
              this.runtime = Duration.ofMinutes(Long.parseLong(br.readLine()));
        }

        @Override
        public void save(BufferedWriter bw) throws IOException
        {
              super.save(bw);
              bw.write("" + Long.toString(runtime.toMinutes()) + '\n');
        }

        @Override
        public String toString()
        {
                return toStringBuilder("Video ", ", runtime: " + runtime.toMinutes() + " minutes").toString();
        }

        private Duration runtime;
}
