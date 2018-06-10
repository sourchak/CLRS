//Problem 2-3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HornersRule
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean check=true;
        int[] A=null;
        while(check)
        {
            System.out.print("Enter the degree of the polynomial: ");
            int degree=Integer.parseInt(br.readLine());
            A=new int[degree+1];
            System.out.print("Enter the coefficents of x starting with the constant term: ");
            String[] s_coeff=br.readLine().split(" ");
            if(s_coeff.length==A.length)
            {
                for(int i=0;i<A.length;i++)
                    A[i]=Integer.parseInt(s_coeff[i]);
                check=false;
            }
            else
                System.out.println("Mismatch in the number of coefficients, which must be 1 greater than entered degree.");
        }
        System.out.print("Enter a value for x: ");
        int x=Integer.parseInt(br.readLine());
        long result=Horners_Rule(A,x);
        System.out.println(result);
    }
    public static long Horners_Rule(int[] A,int x)
    {
        long result=0;
        for(int i=A.length-1;i>=0;i--)
            result=(result*x+A[i]);
        return result;
    }
}
