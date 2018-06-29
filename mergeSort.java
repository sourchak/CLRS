import java.util.Scanner;

public class mergeSort
{
    static int counter=0; //this line is for counting the number of inversions in the array
    public static void main(String[] args)
    {
        System.out.print("Enter the number of elements in the sequence:");
        Scanner s=new Scanner(System.in);
        int[] A=new int[s.nextInt()];
        System.out.println("Enter the said number of elements:");
        for(int i=0;i<A.length;i++)
            A[i]=s.nextInt();
        System.out.print("The sorted sequence is:");
        merge_Sort(A,0,A.length-1);
        for (int x: A)
            System.out.print(" "+x);
        System.out.println();
        System.out.println("Inversions: "+counter);

    }

    public static void merge_Sort(int[] A,int p,int r)
    {
        if (p<r)
        {
            int q=(p+r)/2;
            merge_Sort(A,p,q);
            merge_Sort(A,q+1,r);
            merge(A,p,q,r);
        }
    }
    static void merge(int[] A, int p, int q, int r)
    {
        int n1=q-p+1;
        int n2=r-q;
        int [] L=new int[n1+1], R=new int[n2+1];
        int i,j;
        for(i=0;i<n1;i++)
            L[i]=A[p+i];
        for(j=0;j<n2;j++)
            R[j]=A[q+j+1];
        L[n1]=Integer.MAX_VALUE;
        R[n2]=Integer.MAX_VALUE;
        i=0;
        j=0;
        for(int k=p;k<=r;k++)
        {
            if(L[i]<=R[j])
            {
                A[k]=L[i];
                i++;
            }
            else
            {
                counter++; //increments the inversion counter by 1 for each inversion present in the array
                A[k]=R[j];
                j++;
            }
        }
    }
}
