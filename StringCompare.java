import java.util.Scanner;

public class StringCompare {
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two strings");
        String s1=sc.next();
        String s2=sc.next();
        int difference=s1.compareTo(s2);
        System.out.println(difference);
        
    }
    
}
