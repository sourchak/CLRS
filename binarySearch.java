// Exercise 2.3-5

import java.util.Scanner;

public class binarySearch
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
        s.nextLine();
        System.out.print("Enter the element to be searched for: ");
        int v=-1;
        if (s.hasNextInt())
            v=s.nextInt();
        String message=((counter=binary_Search(A,v))==-1)?"The element could not be found.":"Element found at position "+(counter+1);
        System.out.println(message);
    }
    static int binary_Search(int[] A, int v)
    {
        int lower=0;
        int upper=A.length-1;
        int mid;
        while(lower<=upper)
        {
            mid=(lower+upper)/2;
            if(A[mid]>v)
                upper=mid-1;
            else if (A[mid]<v)
                lower=mid+1;
            else
                return mid;
        }
        return -1;
    }
}

/* the binary_search algorithm finds the element and reports the first time it finds the element, it has more to do with the
 place that the while loop of lines 29-38 first visits. Because binary_search does not compare elements linearly, it may report the second or later reoccurences of an element.
 For example the sequence (1,2,3,4,4,5,6,7,8) of length 9 will return 4 from binary_search and output the 5th position because that is the first place it checked.
*/
