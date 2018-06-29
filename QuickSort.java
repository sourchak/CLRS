import java.util.Scanner;

public class QuickSort 
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int A[]=new int[s.nextInt()];
		System.out.print("Enter the elements of the array: ");
		for(int i=0;i<A.length;i++)
			A[i]=s.nextInt();
		QuickSorter(A,0,A.length-1);
		System.out.println("The sorted array is:");
		for(int x:A)
			System.out.print(x+"\t");
	}
	static void QuickSorter(int A[],int p,int r)
	{
		if(p<r)
		{
			int q=Partition(A,p,r);
			QuickSorter(A,p,q-1);
			QuickSorter(A,q+1,r);
		}
	}	
	static int Partition(int[] A,int p,int r)
	{
		int tmp;
		int x=A[r];
		int i=p-1;
		for(int j=p;j<r;j++)
			if(A[j]<=x)
			{
				i=i+1;
				tmp=A[i];
				A[i]=A[j];
				A[j]=tmp;
			}
		tmp=A[i+1];
		A[i+1]=A[r];
		A[r]=tmp;
		return i+1;
	}
}