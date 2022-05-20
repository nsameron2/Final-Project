import java.io.IOException;

public class Main 
{
    public static void main(String[] args) 
    {
        System.out.println("hi");

        School qwertyuiop = new School("qwertyuiop");
        try {
            qwertyuiop.makeTeachers(10);
        }
        catch (IOException e) {
            System.out.println("hi");
        }
        

    }
}