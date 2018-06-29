import java.util.Scanner;

class index
{
	int row;
	int col;
	index(int r, int c)
	{
		row=r;
		col=c;
	}
}

public class SquareMatrixMultiplyRecursive
{
	static int[][] A;
	static int[][] B;
	public static void main(String[] args)
	{
		int n, C[][];
		System.out.print("Enter the dimension of the matrices: ");
		n=new Scanner(System.in).nextInt();
		System.out.print("Enter the values of the first matrix: ");
		A=inputMatrix(n);
		System.out.print("Enter the values of the second matrix: ");
		B=inputMatrix(n);
		System.out.println("The product matrix is: ");
		long t1=System.nanoTime();
		C=worker(new index(1,1),new index(n,n),new index(1,1),new index(n,n));	
		long t2=System.nanoTime();
		for(int i=0;i<n;i++,System.out.println())
			for(int j=0;j<n;j++)
				System.out.print(C[i][j]+""+"\t");
		System.out.println("Running time: "+((t2-t1)*Math.pow(10,-9)));
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
	static int[][] worker(index a_low, index a_high,index b_low,index b_high)
	{
		if(a_low.row==a_high.row && a_low.col==a_high.col)
			return new int[][]{{A[a_low.row-1][a_low.col-1]*B[b_low.row-1][b_low.col-1]}};
		else
		{
			int[][] c11, c12, c21, c22;
			int[][] temp_c=new int[a_high.row-a_low.row+1][a_high.col-a_low.col+1];
			int a_midrow=(a_low.row+a_high.row)/2;
			int a_midcol=(a_low.col+a_high.col)/2;
			int b_midrow=(b_low.row+b_high.row)/2;
			int b_midcol=(b_low.col+b_high.col)/2;
			c11=addition(worker(new index(a_low.row,a_low.col), new index(a_midrow,a_midcol), new index(b_low.row,b_low.col), new index(b_midrow,b_midcol)),worker(new index(a_low.row,a_midcol+1), new index(a_midrow,a_high.col),new index(b_midrow+1,b_low.col),new index(b_high.row,b_midcol)));
			c12=addition(worker(new index(a_low.row,a_low.col), new index(a_midrow,a_midcol), new index(b_low.row,b_midcol+1), new index(b_midrow,b_high.col)),worker(new index(a_low.row,a_midcol+1), new index(a_midrow,a_high.col),new index(b_midrow+1,b_midcol+1),new index(b_high.row,b_high.col)));
			c21=addition(worker(new index(a_midrow+1,a_low.col),new index(a_high.row,a_midcol), new index(b_low.row,b_low.col),new index(b_midrow,b_midcol)),worker(new index(a_midrow+1,a_midcol+1),new index(a_high.row,a_high.col),new index(b_midrow+1,b_low.col),new index(b_high.row,b_midcol)));
			c22=addition(worker(new index(a_midrow+1,a_low.col),new index(a_high.row,a_midcol), new index(b_low.row,b_midcol+1),new index(b_midrow,b_high.col)),worker(new index(a_midrow+1,a_midcol+1),new index(a_high.row,a_high.col),new index(b_midrow+1,b_midcol+1),new index(b_high.row,b_high.col)));
			for(int i=0;i<a_high.row-a_low.row+1;i++)
			for(int j=0;j<a_high.col-a_low.col+1;j++)
			{
				if(i<c11.length)
				{
					if(j<c11[0].length)
						temp_c[i][j]=c11[i][j];
					else
						temp_c[i][j]=c12[i][j-c11[0].length];
				}
				else
				{
					if(j<c11[0].length)
						temp_c[i][j]=c21[i-c11.length][j];
					else
						temp_c[i][j]=c22[i-c11.length][j-c11[0].length];
				}
			}
			return temp_c;
		}
	}
	static int[][] addition(int[][]P, int[][] Q)
	{
		int[][] R=new int[P.length][P[0].length];
		for(int i=0;i<P.length;i++)
			for(int j=0;j<P[0].length;j++)
				R[i][j]=P[i][j]+Q[i][j];
		return R;
	}
}
