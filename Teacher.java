import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

public class Teacher
{
    String name;
    double happiness = 100;
    double salary;
    double happinessFactor;

    public static boolean quit = true;

    public Teacher() throws IOException
    {
        generateName();
        happiness = Math.random()*100;
        happinessFactor = Math.random()*0.9;
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

        if(happiness < 0)
        {
            System.out.println(name + " wants to quit.");
            System.out.println("1. Give Raise\n2. Fire");
            System.out.print(">  ");

            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    giveRaise(1.2);
                    happiness = 100;
                    break;
                case 2:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public void giveRaise(double raise)
    {
        salary *= raise;
    }

    public double getHappiness()
    {
        return happiness;
    }

    public double getSalary()
    {
        return salary;
    }
}
