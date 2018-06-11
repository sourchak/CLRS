// Exercise 4.2-7
// clever complex multiplication

import java.util.Scanner;

class ComplexMultiplier
{
	public static void main(String[] args)
	{
		int a,b,c,d;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter a complex number x+iy as an ordered pair x y: ");
		a=s.nextInt();
		b=s.nextInt();
		System.out.print("Enter another the same way:");
		c=s.nextInt();
		d=s.nextInt();
		int[] C=cleverComplexMultiplier(a,b,c,d);
		System.out.println("("+a+((b<0)?("-i"+(-b)):("+i"+b))+")*("+c+((d<0)?("-i"+(-d)):("+i"+d))+")= "+C[0]+((C[1]<0)?("-i"+(-C[1])):("+i"+C[1])));
	}
	static int[] cleverComplexMultiplier(int a, int b, int c, int d)
	{
		int p1=a*(c+d);
		int p2=b*(c-d);
		int p3=d*(a+b);
		return new int[]{p1-p3,p2+p3};
	}

}