import java.util.Scanner;

public class SquareMatrixMultiply
{
	public static void main(String[] args)
	{
		int n,A[][],B[][],C[][];
		System.out.print("Enter the dimensions of the matrices: ");
		n=new Scanner(System.in).nextInt();
		System.out.println("Enter the values of the first matrix:");
		A=inputMatrix(n);
		System.out.println("Enter the values of the second matrix:");
		B=inputMatrix(n);
		C=worker(A,B);
		for(int i=0;i<n;i++,System.out.println())
			for(int j=0;j<n;j++)
				System.out.print(C[i][j]+""+"\t");
	}
	static int[][] inputMatrix(int n)
	{
		int[][] A=new int[n][n];
		Scanner s=new Scanner(System.in);
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				A[i][j]=s.nextInt();
		return A;
	}
	static int[][] worker(int[][] A, int[][] B)
	{
		int C[][]=new int[A.length][A[0].length];
		for(int i=0;i<A.length;i++)
			for(int j=0;j<B[0].length;j++)
				for(int k=0;k<A[0].length;k++)
					C[i][j]+=(A[i][k]*B[k][j]);
		return C;
	}
}