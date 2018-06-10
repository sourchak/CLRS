//Problem 2-2

import java.util.Scanner;

public class bubbleSort
{
    public static void main(String[] args)
    {
        System.out.print("Enter the number of elements in the sequence:");
        Scanner s=new Scanner(System.in);
        int[] A=new int[s.nextInt()];
        System.out.print("Enter the said number of elements:");
        int counter=0;
        while (counter<A.length && s.hasNext())
            A[counter++]=s.nextInt();
        bubble_Sort(A);
        System.out.print("The sorted list is: ");
        for(int x:A)
            System.out.print(x+" ");
        System.out.println();
    }
    public static void bubble_Sort(int A[])
    {
        for(int i=0,count=0;i<A.length-1;i++,count=0)
        {
            for(int j=A.length-1;j>i;j--)
                if(A[j]<A[j-1])
                {
                    count++;
                    A[j]+=A[j-1];
                    A[j-1]=A[j]-A[j-1];
                    A[j]=A[j]-A[j-1];
                }
            //the rest of this outer for loop is an optimization to stop bubble_Sort once the array is already sorted
            if(count==0)
                break;
        }
    }
}
