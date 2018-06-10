import java.util.Scanner;

public class GCD
{
    public long euclid(long a, long b)
    {
        if (b==0|| a==0)
            return (long)a|(long)b;
        else
            euclid(b,a%b);
    }
    public static void main(String a[])
    {
        System.out.print("Enter numbers whose GCD is to be computed: ");
        Scanner s= new Scanner(System.in);
        int numbers[]=new int[2];
        int i=0;
        while(s.hasNextLong() && i<2)
            numbers[i++]=s.nextLong();
        System.out.println("GCD("+numbers[0]+", "+numbers[1]+")= "+new GCD().euclid(numbers[1],numbers[2]));
    }
}
