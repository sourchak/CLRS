import java.util.Scanner;

public class insertionSort
{
    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of keys in the list to be sorted:");
        int A[]=new int[s.nextInt()];
        System.out.print("Enter the list of elements:");
        for(int i=0;i<A.length;i++)
            A[i]=s.nextInt();
        A = sort(A);
        System.out.println("The sorted list is:");
        for(int x: A)
        System.out.print(x+" "+'\t');
        System.out.println();
    }
    public static int[] sort(int[] A)
    {
        int key;
        for(int i=1,j;i<A.length;i++)
        {
            key=A[i];
            j=i-1;
            while(j>=0 && A[j]>key)
            {
                A[j+1]=A[j];
                j--;
            }
            A[j+1]=key;
        }
        return A;
    }
}
