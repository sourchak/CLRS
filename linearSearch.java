import java.util.Scanner;

public class linearSearch
{
    public static void main(String a[])
    {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array:");
        int A[]=new int[s.nextInt()];
        System.out.print("Enter the list of elements:");
        for(int i=0;i<A.length;i++)
            A[i]=s.nextInt();
        System.out.print("Enter the element to search for, the index of which, if found shall be returned: ");
        int alpha=s.nextInt();
        int pos=search(A,alpha);
        System.out.println(pos>=0?("Element found at position: "+pos):"Element not found" );
    }
    static int search(int [] A, int alpha)
    {
        for(int i=0;i<A.length;i++)
        if (A[i]==alpha)
            return i;
        return -1;
    }
}
