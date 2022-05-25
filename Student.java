import java.io.IOException;
import java.io.File;
import java.io.RandomAccessFile;

public class Student 
{
    private double gpa;
    private String name;

    public Student(double g) throws IOException
    {
        generateName();
        gpa = g;
    }

    public String getName()
    {
        return name;
    }

    public double getGPA()
    {
        return gpa;
    }

    private void generateName() throws IOException
    {
        File file = new File("studentnames.txt");
        RandomAccessFile names = new RandomAccessFile(file, "r");
        names.seek((int)(Math.random()*names.length()));
            
        String studentName = names.readLine();

        if(studentName.equals("") || studentName.length() <= 1)
        {
            this.generateName();
        }
        else
        {
            studentName = studentName.substring(0, 1).toUpperCase() + studentName.substring(1);
            name = studentName;
        }
    }
}
