import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class School 
{
    private String name;
    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    
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
            Teacher t = new Teacher();
            teachers.add(t);

        }
    }

    public void makeStudents(int times) throws IOException
    {
        for(int i = 0; i < times; i++)
        {
            Student s = new Student();
            students.add(s);
        }
    }



    public void manage()
    {

        System.out.println("Welcome to " + getName() + " 's management system.");
        System.out.println("What would you like to do?");

        
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;

        while(!exit)
        {
            System.out.println("\n1. View Teachers\n2. View Students\n3. Manage Teachers\n4. Manage Students\n5. Manage School\n6. Exit");
            System.out.print(">  ");
            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    viewTeachers();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    manageTeachers();
                    break;
                case 4:
                    manageStudents();
                    break;
                case 5:
                    manageSchool();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        
    }

    public void viewTeachers()
    {
        System.out.println("\n\u001B[32m" + "Teachers: " + "\u001B[0m");
        for(int i = 0; i < teachers.size(); i++)
        {
            System.out.println((i+1) + ". " + teachers.get(i).getName());
        }
    }

    public void viewStudents()
    {
        System.out.println("\n\u001B[34m" + "Students: " + "\u001B[0m");
        for(int i = 0; i < students.size(); i++)
        {
            System.out.println((i+1) + ". " + students.get(i).getName() + "\t\tGPA: " + students.get(i).getGPA());
        }
    }

    public void manageTeachers()
    {
        viewTeachers();
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. View Teachers 2. Add Teacher\n3. Remove Teacher\n4. Exit");
    }

    public void manageStudents()
    {
        
    }

    public void manageSchool()
    {
        
    }
}
