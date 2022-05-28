import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class Student 
{
    private double gpa;
    private String name;
    private String firstName;
    private String lastName;

    double happiness;
    double happinessFactor;

    boolean absent = false;

    public Student() throws IOException
    {
        firstName = generateName();
        lastName = generateName();
        name = firstName + " " + lastName;
        gpa = Math.random()*4;
        gpa = Math.round(gpa*100.0)/100.0;

        happiness = Math.random()*100;
        happinessFactor = 0.9;
    }

    public String getName()
    {
        return name;
    }

    public double getGPA()
    {
        return gpa;
    }

    private String generateName() throws IOException
    {
        File file = new File("studentnames.txt");
        RandomAccessFile names = new RandomAccessFile(file, "r");
        names.seek((int)(Math.random()*names.length()));
            
        String studentName = names.readLine();

        if(studentName.equals("") || studentName.length() <= 1)
        {
            return generateName();
        }
        else
        {
            studentName = studentName.substring(0, 1).toUpperCase() + studentName.substring(1);
            return studentName;
        }
    }

    public void school()
    {
        absent = false;

        int rand = (int)(Math.random()*10)+1;

        if(rand == 1)
        {
            System.out.println(name + " is absent today.");
            absent = true;
            return;
        }
        else if(rand == 2)
        {
            // to be added
            System.out.println("hi");
        }
        

    }

    public boolean isAbsent()
    {
        return absent;
    }
}