import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Tutor extends Teacher
{
    public Tutor() throws IOException
    {
        super();

        salary *= 5;
    }

    public void generateName() throws IOException
    {
        File file = new File("francais.txt");
        RandomAccessFile names = new RandomAccessFile(file, "r");
        names.seek((int)(Math.random()*names.length()));
            
        String teacherName = names.readLine();

        if(teacherName.equals("") || teacherName.length() <= 1)
        {
            this.generateName();
        }
        else
        {
            teacherName = teacherName.substring(0, 1).toUpperCase() + teacherName.substring(1);

            int rand = (int)(Math.random()*3)+1;
            String t;

            if(rand == 1)
            {
                t = "Monsieur ";
            }
            else if(rand == 2)
            {
                t = "Madame ";
            }
            else
            {
                t = "Mademoiselle ";
            }

            String temp;
            temp = t + teacherName;
            teacherName = temp;

            name = teacherName;
        }
    }
}