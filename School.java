import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public class School 
{
    private String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    
    public School(String n)
    {
        name = n;
    }

    public String getName()
    {
        return name;
    }

    public void makeTeachers(int times) throws IOException
    {
        for(int i = 0; i < times; i++)
        {
            File file = new File("names.txt");
            RandomAccessFile names = new RandomAccessFile(file, "r");
            names.seek((int)(Math.random()*names.length()));
            
            String teacherName = names.readLine();

            if(teacherName.equals(""))
            {
                makeTeachers(1);
            }
            else
            {
                Teacher t = new Teacher(teacherName);
                System.out.println(t.getName());
                teachers.add(t);
            }

        }
    }
}
