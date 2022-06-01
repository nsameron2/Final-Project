import java.io.IOException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("What would you like to name your school?");
        System.out.print("> ");

        Scanner keyboard = new Scanner(System.in);
        String name = keyboard.next();

        School school = new School(name);
        boolean exit = false;

        System.out.println("\nWelcome to " + school.getName() + "'s management system.");
        System.out.println("What would you like to do?");

        while(!exit)
        {
            school.manage();
        }
        
    }
}