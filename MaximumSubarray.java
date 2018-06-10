import java.util.Scanner;

class RetStruct
{
	int low;
	int high;
	int sum;
	RetStruct(int i,int j, int k)
	{
		low=i;
		high=j;
		sum=k;
	}
}
class MaximumSubarray
{
	public static void main(String[] args)
	{
		int n;
		int[] A;
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of elements in the array:");
		A=new int[n=s.nextInt()];
		System.out.println("Enter the elements in the array:");
		for(int i=0;i<n;i++)
			A[i]=s.nextInt();
		RetStruct answer=new MaximumSubarray().find_maximum_subarray(A,0,A.length-1);
		System.out.println("low: "+answer.low+", high: "+answer.high+", sum: "+answer.sum);
	}
	RetStruct find_maximum_subarray(int A[],int low,int high)
	{
		if(low==high)
			return new RetStruct(low,high,A[low]);
		else
		{
			int mid=(low+high)/2;
			RetStruct left=find_maximum_subarray(A,low,mid);
			RetStruct right=find_maximum_subarray(A,mid+1,high);
			RetStruct cross=find_max_crossing_subarray(A,low,mid,high);
			if(left.sum>=right.sum && left.sum>=cross.sum)
				return left;
			else if(right.sum>=left.sum && right.sum>=cross.sum)
				return right;
			else 
				return cross;
		}
	}
	RetStruct find_max_crossing_subarray(int A[],int low,int mid, int high)
	{
		int left_sum=Integer.MIN_VALUE,right_sum=Integer.MIN_VALUE;
		int max_left=mid,max_right=mid+1;
		for(int i=mid,sum=0;i>=low;i--)
			if((sum+=A[i])>left_sum)
			{
				left_sum=sum;
				max_left=i;
			}
		for(int i=mid+1,sum=0;i<=high;i++)
			if((sum+=A[i])>right_sum)
			{
				right_sum=sum;
				max_right=i;
			}
		return new RetStruct(max_left,max_right,left_sum+right_sum);
	}
}