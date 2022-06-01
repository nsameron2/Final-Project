import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class School 
{
    private String name;

    public double balance;

    int days = 0;
    int maxStudents;

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();
    ArrayList<Student> students = new ArrayList<Student>();
    ArrayList<Tutor> tutors = new ArrayList<Tutor>();
    
    public School(String n) throws IOException
    {
        name = n;

        System.out.println("\u001B[36m" + "Please choose a starting pacakge." + "\u001B[0m");
        System.out.println("1. Balance: $2000\tTeachers: 1\tStudents: 5");
        System.out.println("2. Balance: $1500\tTeachers: 2\tStudents: 10");
        System.out.println("3. Balance: $1000\tTeachers: 3\tStudents: 15");
        
        System.out.print("> ");

        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        switch(choice)
        {
            case 1:
                balance = 2000;
                makeTeachers(1);
                makeStudents(5);
                break;

            case 2:
                balance = 1500;
                makeTeachers(2);
                makeStudents(10);
                break;

            case 3:
                balance = 1000;
                makeTeachers(3);
                makeStudents(15);
                break;
        }

        calculateMaxStudents();
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

    public void calculateMaxStudents()
    {
        maxStudents = teachers.size() * 10;
    }


    public void manage() throws IOException
    {

        // System.out.println("\nWelcome to " + getName() + " 's management system.");
        // System.out.println("What would you like to do?");

        
        Scanner keyboard = new Scanner(System.in);
        boolean exit = false;

        while(!exit)
        {
            System.out.println("\n1. View Stats\n2. Manage\n3. Next Day\n0. Exit");
            System.out.print(">  ");
            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("\nWhat would you like to view?");
                    System.out.println("1. Teachers\n2. Students\n3. Tutors\n4. School Stats\n5. Exit");
                    System.out.print("> ");

                    choice = keyboard.nextInt();

                    switch(choice)
                    {
                        case 1:
                            viewTeachers();
                            break;
                        case 2:
                            viewStudents();
                            break;
                        case 3:
                            viewTutors();
                            break;
                        case 4:
                            viewStats();
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nWhat would you like to manage?");
                    System.out.println("1. Teachers\n2. Tutors\n3. Exit");
                    System.out.print("> ");

                    choice = keyboard.nextInt();

                    switch(choice)
                    {
                        case 1:
                            manageTeachers();
                            break;
                        case 2:
                            manageTutors();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                    break;
                case 3:
                    day();
                    break;
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
            System.out.println((i+1) + ". " + teachers.get(i).getName() + "\t\u001B[33mHappiness: \u001B[0m" + Math.round(teachers.get(i).getHappiness()*100.0)/100.0 + "\t\u001B[32mSalary: \u001B[0m" + teachers.get(i).getSalary());
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

    public void viewTutors()
    {
        System.out.println("\n\u001B[36m" + "Tutors: " + "\u001B[0m");
        for(int i = 0; i < tutors.size(); i++)
        {
            System.out.println((i+1) + ". " + tutors.get(i).getName() + "\t\tHappiness: " + tutors.get(i).getHappiness() + "\tSalary: " + tutors.get(i).getSalary());
        }
    }

    public void viewStats()
    {
        System.out.println("\u001B[35m" + name + " School:" + "\u001B[0m");
        System.out.println("Student Capacity: " + students.size() + "/" + maxStudents);
        System.out.println("Balance: $" + balance);
        System.out.println("Average GPA: " + averageGPA());
        System.out.println("Average Happiness: " + averageHappiness());
    }

    public void manageTeachers() throws IOException
    {
        boolean exit = false;
        Scanner keyboard = new Scanner(System.in);
        while(!exit)
        {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View Teachers\n2. Hire Teacher\n3. Fire Teacher\n4. Exit");
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

    public void manageTutors() throws IOException
    {
        boolean exit = false;
        Scanner keyboard = new Scanner(System.in);
        while(!exit)
        {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View Tutors\n2. Hire Tutor\n3. Fire Tutor\n4. Exit");
            System.out.print(">  ");

            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    viewTutors();
                    break;
                case 2:
                    hireTutor();
                    break;
                case 3:
                    viewTutors();
                    System.out.println("Which tutor would you like to fire?");
                    System.out.print(">  ");

                    choice = keyboard.nextInt();

                    fireTutor(choice);
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

    private void hireTeacher() throws IOException
    {
        int rand = (int)(Math.random()*2)+3;
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

        System.out.println("\u001B[36m" + "Which teacher would you like to hire?" + "\u001B[0m");
        System.out.print(">  ");

        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        teachers.add(avail.get(choice-1));

        calculateMaxStudents();
    }

    private void hireTutor() throws IOException
    {
        int rand = (int)(Math.random()*2)+3;
        ArrayList<Tutor> avail = new ArrayList<Tutor>();
        for(int i = 0; i < rand; i++)
        {
            Tutor temp = new Tutor();
            avail.add(temp);
        }

        for(int i = 0; i < avail.size(); i++)
        {
            System.out.println((i+1) + ". " + avail.get(i).getName());
        }

        System.out.println("\u001B[36m" + "Which tutor would you like to hire?" + "\u001B[0m");
        System.out.print(">  ");

        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();

        tutors.add(avail.get(choice-1));
    }

    private void fireTeacher(int index)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            if((i+1) == index)
            {
                System.out.println("\u001B[31m" + "You have fired " + teachers.get(i).getName() + "." + "\u001B[0m");
                teachers.remove(i);
               
                return;
            }
        }
    }

    private void fireTutor(int index)
    {
        for(int i = 0; i < tutors.size(); i++)
        {
            if((i+1) == index)
            {
                System.out.println("\u001B[31m" + "You have fired " + tutors.get(i).getName() + "." + "\u001B[0m");
                tutors.remove(i);
               
                return;
            }
        }
    }

    public void pay(double amt, String reason)
    {
        balance -= amt;
        System.out.println("\u001B[32m" + "You have paid $" + amt + " for " + reason + "." + "\u001B[0m");
    }


    public void day() throws IOException
    {
        days++;
        System.out.println("Day " + days + ":");

        for(int i = 0; i < teachers.size(); i++)
        {
            teachers.get(i).work();
            balance -= teachers.get(i).getSalary();

            if(teachers.get(i).getHappiness() < (int)(Math.random()*25)+10)
            {
            System.out.println("\u001B[31m" + teachers.get(i).getName() + " wants to quit." + "\u001B[0m");
            System.out.println("1. Give Raise\n2. Fire");
            System.out.print(">  ");

            Scanner keyboard = new Scanner(System.in);
            int choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    teachers.get(i).giveRaise(1.2);
                    System.out.println("You have given " + teachers.get(i).getName() + " a raise. Their salary is now $" + teachers.get(i).getSalary() + " a day.");
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
                balance += 1 * students.get(i).getGPA();
            }
        }

        for(int i = 0; i < tutors.size(); i++)
        {
            balance -= tutors.get(i).getSalary();

            for(int a = 0; a < students.size(); a++)
            {
                students.get(a).study();
            }
        }

        for(int i = students.size(); i < teachers.size()*10; i++)
        {
            int rand = (int)(Math.random()*3);

            if(rand == 0)
            {
                students.add(new Student());
                System.out.println(students.get(students.size()-1).getName() + " has joined the school.");
            }
        }
    }

    public void viewBalance()
    {
        System.out.println("\nBalance: $" + balance);
    }

    public void newStudent(int amount) throws IOException
    {
        for(int i = 0; i < amount; i++)
        {
            students.add(new Student());
        }
    }

    public double averageGPA()
    {
        double totalGPA = 0;

        for(int i = 0; i < students.size(); i++)
        {
            totalGPA += students.get(i).getGPA();
        }

        double aGPA = totalGPA / students.size();
        aGPA = Math.round(aGPA*100.0)/100.0;
        return aGPA;
    }

    public double averageHappiness()
    {
        double totalHappiness = 0;

        for(int i = 0; i < teachers.size(); i++)
        {
            totalHappiness += teachers.get(i).getHappiness();
        }

        double aHappiness = totalHappiness / teachers.size();
        aHappiness = Math.round(aHappiness*100.0)/100.0;
        return aHappiness;
    }
}
