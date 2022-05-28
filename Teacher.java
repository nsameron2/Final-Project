import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Teacher
{
    String name;
    double happiness = 100;
    double salary = 15;
    double happinessFactor;
    double teachingLevel;

    private boolean quit = false;

    public Teacher() throws IOException
    {
        generateName();
        happiness = Math.random()*100;
        happinessFactor = 0.9;
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

    public void work()
    {
        System.out.println(name + " has worked.");

        happiness *= happinessFactor;

        
    }

    public void giveRaise(double raise)
    {
        salary *= raise;
        happiness = 100;
    }

    public double getHappiness()
    {
        return happiness;
    }

    public double getSalary()
    {
        return salary;
    }

    public boolean getQuit()
    {
        return quit;
    }
}
