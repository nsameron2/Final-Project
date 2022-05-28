import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class School 
{
    private String name;

    public double balance = 1000;

    int days = 0;

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    
    public School(String n) throws IOException
    {
        name = n;

        makeTeachers(3);
        makeStudents(10);
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



    public void manage() throws IOException
    {

        // System.out.println("\nWelcome to " + getName() + " 's management system.");
        // System.out.println("What would you like to do?");

        
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;

        while(!exit)
        {
            System.out.println("\n1. View Teachers\n2. View Students\n3. View Balance\n4. Manage Teachers\n5. Manage Students\n6. Manage School\n7. Next Day\n0. Exit");
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
                    viewBalance();
                    break;
                case 4:
                    manageTeachers();
                    break;
                case 5:
                    manageStudents();
                    break;
                case 6:
                    manageSchool();
                    break;
                case 7:
                    day();
                case 0:
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
            System.out.println((i+1) + ". " + teachers.get(i).getName() + "\tHappiness: " + teachers.get(i).getHappiness() + "\tSalary: " + teachers.get(i).getSalary());
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

    public void manageTeachers() throws IOException
    {
        boolean exit = false;
        Scanner keyboard = new Scanner(System.in);
        while(!exit)
        {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View Teachers 2. Hire Teacher\n3. Fire Teacher\n4. Exit");
            System.out.print(">  ");

            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    viewTeachers();
                    break;
                case 2:

                    hireTeacher();
                    break;
                case 3:
                    viewTeachers();
                    System.out.println("Which teacher would you like to fire?");
                    System.out.print(">  ");

                    choice = keyboard.nextInt();

                    fireTeacher(choice);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public void manageStudents()
    {
        
    }

    public void manageSchool()
    {
        
    }

    private void hireTeacher() throws IOException
    {
        int rand = (int)(Math.random()*5)+3;
        ArrayList<Teacher> avail = new ArrayList<Teacher>();
        for(int i = 0; i < rand; i++)
        {
            Teacher temp = new Teacher();
            avail.add(temp);
        }

        for(int i = 0; i < avail.size(); i++)
        {
            System.out.println((i+1) + ". " + avail.get(i).getName());
        }

        System.out.println("Which teacher would you like to hire?");
        System.out.print(">  ");

        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        teachers.add(avail.get(choice-1));
    }

    private void fireTeacher(int index)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            if((i+1) == index)
            {
                System.out.println("You have fired " + teachers.get(i).getName() + ".");
                teachers.remove(i);
               
                return;
            }
        }
    }

    public void pay(double amt, String reason)
    {
        balance -= amt;
        System.out.println("You have paid $" + amt + " for " + reason + ".");
    }


    public void day()
    {
        days++;
        System.out.println("Day " + days + ":");

        for(int i = 0; i < teachers.size(); i++)
        {
            teachers.get(i).work();
            balance -= teachers.get(i).getSalary();

            if(teachers.get(i).getHappiness() < (int)(Math.random()*25)+10)
        {
            System.out.println(teachers.get(i).getName() + " wants to quit.");
            System.out.println("1. Give Raise\n2. Fire");
            System.out.print(">  ");

            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    teachers.get(i).giveRaise(1.2);
                    break;
                case 2:
                    fireTeacher(i+1);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
        }

        for(int i = 0; i < students.size(); i++)
        {
            students.get(i).school();
            
            if(!students.get(i).isAbsent())
            {
                balance += 5;
            }
        }
    }

    public void viewBalance()
    {
        System.out.println("\nBalance: $" + balance);
    }
}
