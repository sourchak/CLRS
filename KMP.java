import java.util.Scanner;

class KMP
{
	//TO DO: INPUT AND OUTPUT ARE TO BE READ FROM FILES.
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the text in which to search: ");
		String T=input.nextLine();
		System.out.print("Enter the pattern to be searched for: ");
		String P=input.nextLine();
		kmpMatcher(T,P);
	}
	static void kmpMatcher(String T,String P)
	{
		int n=T.length();
		int m=P.length();
		int[] pi=computePrefixFunction(P);
		int q=-1;
		for(int i=0; i<n;i++)
		{
			while(q>-1 && T.charAt(i)!=P.charAt(q+1))
				q=pi[q];
			if(T.charAt(i)==P.charAt(q+1))
				q=q+1;
			if(q==m-1)
			{
				System.out.println("Pattern occurs in the text with shift:"+(i-(m-1)));
				q=pi[q];
			}
		}
	}
	static int[] computePrefixFunction(String P)
	{
		int m=P.length();
		int[] pi=new int[m];
		pi[0]=-1;
		int k=-1;
		for(int q=1;q<m;q++)
		{
			while(k>-1 && P.charAt(k+1)!=P.charAt(q))
				k=pi[k];
			if(P.charAt(k+1)==P.charAt(q))
				k=k+1;
			pi[q]=k;
		}
		return pi;
	}
}