package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class Patron
{
        public Patron(String name, String email)
        {
                this.name = name;
                this.email = email;
        }

        public Patron(BufferedReader br) throws IOException
        {
                this.name = br.readLine();
                this.email = br.readLine();
        }
        
        public void save(BufferedWriter bw) throws IOException
        {
                bw.write(name + '\n');
                bw.write(email + '\n');
        }


        @Override
        public String toString()
        {
                return name + " (" + email + ")";
        }

        private String name;
        private String email;
}
