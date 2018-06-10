// Exercise 2.2-2

import java.util.Scanner;

public class selectionSort
{
    public static void main(String[] args)
    {
        System.out.print("Enter the number of elements in the sequence:");
        Scanner s=new Scanner(System.in);
        int[] A=new int[s.nextInt()];
        System.out.print("Enter the said number of elements:");
        for(int i=0;i<A.length;i++)
            A[i]=s.nextInt();
        System.out.print("The sorted sequence is:");
        selection_Sort(A);
        for(int x: A)
            System.out.print(" "+x);
        System.out.println();
    }
    public static void selection_Sort(int [] A)
    {
        int pos;
        for(int i=0;i<A.length-1;i++)
        {
            pos=i;
            for(int j=i+1;j<A.length;j++)
            if(A[pos]>A[j])
                pos=j;
            if(pos!=i)
            {
                A[pos]=A[i]+A[pos];
                A[i]=A[pos]-A[i];
                A[pos]=A[pos]-A[i];
            }
        }
    }

    /*
    This is a variation that finds the ith largest element of the list at the ith iteration and places it at position A[A.length-1-i]

    public static void selection_Sort(int [] A)
    {
        int pos;
        for(int i=0;i<A.length;i++)
        {
            pos=0;
            for(int j=1;j<A.length-i;j++)
            if(A[pos]<A[j])
                pos=j;
            if(pos!=A.length-i-1)
            {
                A[A.length-i-1]=A[A.length-i-1]+A[pos];
                A[pos]=A[A.length-i-1]-A[pos];
                A[A.length-i-1]=A[A.length-i-1]-A[pos];
            }
        }
    }*/
}
