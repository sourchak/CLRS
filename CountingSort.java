import java.util.Scanner;

class CountingSort
{
	public static void main(String[] args)
	{
		Scanner s= new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int n=s.nextInt();
		System.out.print("Enter the elements in the array: ");
		int A[]=new int[n];
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			A[i]=s.nextInt();
			if(A[i]>max)
				max=A[i];
		}
		A=countingSort(A,max);
		System.out.println("The sorted array is: ");
		for(int x: A)
			System.out.print(x+""+'\t');
	}
	static int[] countingSort(int A[],int h)
	{
		int C[]=new int[h];
		int B[]=new int[A.length];
		for(int i=0;i<h;i++)
			C[i]=0;
		for(int i=0;i<A.length;i++)
			C[A[i]-1]=C[A[i]-1]+1;
		for(int i=1;i<h;i++)
			C[i]=C[i]+C[i-1];
		for(int i=A.length-1;i>-1;i--)
		{
			B[C[A[i]-1]-1]=A[i];
			C[A[i]-1]=C[A[i]-1]-1;
		}
		return B;
	}
}