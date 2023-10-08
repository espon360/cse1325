// Copyright 2023 An N. Duong <https://github.com/espon360/cse1325.git>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or
// any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.time.Duration;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * Models a video using the Publication constructor with an added video Runtime
 *
 * @author                An N. Duong
 * @version               1.0
 * @since                 1.0
 * @licence.agreement     GNU General Public License 3.0
 */

public class Video extends Publication
{
        /**
          * A special Exception thrown for invalid video length
          *
          * @author                An N. Duong
          * @version               1.0
          * @since                 1.0
          * @licence.agreement     GNU General Public License 3.0
          */
        public class InvalidRuntimeException extends ArithmeticException
        {
                public InvalidRuntimeException(){super();}
                public InvalidRuntimeException(String message){super(message);}
                public InvalidRuntimeException(String title, int runtime) {super(title + " has invalid runtime: " + runtime);}
        }

        /**
          * Creates a Video instance.
          *
          * @param title        the title of the movie
          * @param author       the main director of the movie
          * @param copyright    the year the movie came out / copyrighted
          * @param runtime      the duration of the video in minutes
          * @throws InvalidRuntimeException if runtime is zero or negative
          * @since 1.0
          */
        public Video(String title, String author, int copyright, int runtime)
        {
                super(title, author, copyright);
                if(runtime < 1)
                    throw new InvalidRuntimeException(title, runtime);
                this.runtime = Duration.ofMinutes(runtime);
        }

        /**
          * Creates a Video instance by loading a save file.
          *
          * @param br          the save file to load from
          * @throws IOException when we can't read the file
          * @since             1.0
          */
        public Video(BufferedReader br) throws IOException
        {
              super(br);
              this.runtime = Duration.ofMinutes(Long.parseLong(br.readLine()));
        }

        @Override
        /**
          * Saves the Video's data to a text file
          *
          * @param bw          the file you are saving to
          * @throws IOException when we can't write to the file
          * @since             1.0
          */
        public void save(BufferedWriter bw) throws IOException
        {
              super.save(bw);
              bw.write("" + Long.toString(runtime.toMinutes()) + '\n');
        }

        @Override
        /**
          * Returns a string with the Video's information
          *
          * @since               1.0
          */
        public String toString()
        {
                return toStringBuilder("Video ", ", runtime: " + runtime.toMinutes() + " minutes").toString();
        }

        private Duration runtime;
}
