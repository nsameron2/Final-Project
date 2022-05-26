import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class Student 
{
    private double gpa;
    private String name;
    private String firstName;
    private String lastName;

    public Student() throws IOException
    {
        firstName = generateName();
        lastName = generateName();
        name = firstName + " " + lastName;
        gpa = Math.random()*4;
        gpa = Math.round(gpa*100.0)/100.0;
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
}