import java.util.Scanner;

public class GCD
{
    public long euclid(long a, long b)
    {
        if (b==0 || a==0)
            return a|b;
        else
        {
            System.out.println(a+" "+b);
            return euclid(b,a%b);
        }
    }
    public static void main(String a[])
    {
        System.out.print("Enter numbers whose GCD is to be computed: ");
        Scanner s= new Scanner(System.in);
        long numbers[]=new long[2];
        int i=0;
        while(i<2 && s.hasNextLong())
            numbers[i++]=s.nextLong();
        System.out.println("GCD("+numbers[0]+", "+numbers[1]+")= "+new GCD().euclid(numbers[0],numbers[1]));
    }
}
