import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;

public class Teacher
{
     String name;

    public Teacher() throws IOException
    {
        generateName();
    }

    public String getName()
    {
        return name;
    }
    
    public void generateName() throws IOException
    {
        File file = new File("teachernames.txt");
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
                t = "Mr. ";
            }
            else if(rand == 2)
            {
                t = "Mrs. ";
            }
            else
            {
                t = "Ms. ";
            }

            String temp;
            temp = t + teacherName;
            teacherName = temp;

            name = teacherName;
        }
    }
}
