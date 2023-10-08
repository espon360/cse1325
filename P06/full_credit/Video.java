package library;

import java.time.Duration;

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
        @Override
        public String toString()
        {
                return toStringBuilder("Video ", ", runtime: " + runtime.toMinutes() + " mintures.").toString();
        }

        private Duration runtime;
}
