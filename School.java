import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class School 
{
    private String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    private int numTeachers;
    
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

    public void manage()
    {
        System.out.println("Welcome to " + getName() + " 's management system.");
        System.out.println("What would you like to do?");

        System.out.println("1. View Teachers\n2. View Students\n3. Manage Teachers\n4. Manage Students\n5. Manage School");
        Scanner keyboard = new Scanner(System.in);

        int choice = keyboard.nextInt();

        // switch(choice)
        // {
        //     case 1:
        //         viewTeachers();
        //         break;
        //     case 2:
        //         viewStudents();
        //         break;
        //     case 3:
        //         manageTeachers();
        //         break;
        //     case 4:
        //         manageStudents();
        //         break;
        //     case 5:
        //         manageSchool();
        //         break;
        //     default:
        //         System.out.println("Invalid choice.");
        //         break;
        // }
    }

    public void viewTeachers()
    {
        System.out.println("Teachers: ");
        for(int i = 0; i < teachers.size(); i++)
        {
            System.out.println((i+1) + ". " + teachers.get(i).getName());
        }
    }

    public void viewStudents()
    {
        
    }

    public void manageTeachers()
    {
        
    }

    public void manageStudents()
    {
        
    }

    public void manageSchool()
    {
        
    }
}
