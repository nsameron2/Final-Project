import java.io.IOException;

public class Main 
{
    public static void main(String[] args) throws IOException
    {

        School qwertyuiop = new School("qwertyuiop");


        // qwertyuiop.viewTeachers();
        // qwertyuiop.viewStudents();
        boolean exit = false;

        System.out.println("\nWelcome to " + qwertyuiop.getName() + " 's management system.");
        System.out.println("What would you like to do?");

        while(!exit)
        {
            qwertyuiop.manage();
        }
        
    }
}