// This algorithm is taken from https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
// It computes a solution to the maximum subarry problem in linear time
// It is the answer to Exercise 4.1-5
// It think my rendition works better than geeksforgeeks.org

import java.util.Scanner;

class Kadane
{
	static int low,high,sum;
	public static void main(String a[])
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of elements in the array: ");
		int A[]=new int[s.nextInt()];
		System.out.print("Enter the elements of the array: ");
		for(int i=0;i<A.length;i++)
			A[i]=s.nextInt();
		modifiedKadane(A);
		System.out.println("Start index: "+low+"\nEnd index: "+high+"\nSum: "+sum);
	}
	static void modifiedKadane(int[] A)
	{
		int curr_sum=A[0];
		sum=A[0];
		for(int i=1,temp_low=0;i<A.length;i++)
		{
			/*
			If this method is correct then notice the observation that the starting point of a probable maximal subarray only changes in
			curr_sum is negative and the present element is greater than then curr_sum.
			If curr_sum is positive and:
			- If A[i] greater than curr_sum, then curr_sum+A[i]>curr_sum
			- If A[i] is less than curr_sum, then 	if A[i]>0, curr_sum+A[i]>curr_sum
													if A[i]<0 curr_sum+A[i]<curr_sum but this does not warrant changeing the starting point
													of the subarray as doing so will yeild a lower sum.
			If curr_sum is negative and:
			-If A[i]<curr_sum then changing the starting point of the subarray to A[i] will yeild a lower curr_sum.
			*/
			if(curr_sum<0 && A[i]>curr_sum) 
			{
				curr_sum=A[i];
				temp_low=i;
			}
			else
				curr_sum+=A[i];
			if(sum<curr_sum)
			{
				sum=curr_sum;
				low=temp_low;
				high=i;
			}
		}
	}
}