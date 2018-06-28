import java.util.Scanner;

class Heap
{
	int heapSize;
	int A[];
	Heap(int[] iv)
	{
		A=iv;
		heapSize=iv.length;
	}
	int left(int i)
	{
		return ((i<<1)+1);
	}
	int right(int i)
	{
		return ((i<<1)+2);
	}
	int parent(int i)
	{
		if(i%2==0)
			return i/2-1;
		else
		return (i/2);
	}
	public void maxHeapify(Heap h,int i)
	{
		int l=left(i);
		int r=right(i);
		int largest;
		if(l<h.heapSize && h.A[l]>h.A[i])
			largest=l;
		else
			largest=i;
		if(r<h.heapSize && h.A[r]>h.A[largest])
			largest=r;
		if (largest!=i)
		{
			h.A[largest]+=h.A[i];
			h.A[i]=h.A[largest]-h.A[i];
			h.A[largest]=h.A[largest]-h.A[i];
			maxHeapify(h,largest);
		}
	}
	public Heap buildMaxHeap(Heap h)
	{
		for(int i=parent(h.heapSize-1);i>=0;i--)
			maxHeapify(h,i);
		return h;
	}
}
public class HeapSort
{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		System.out.print("Enter the number of elements in the heap: ");
		int n=s.nextInt();
		System.out.print("Enter the elements in the heap: ");
		int A[]=new int[n];
		for(int i=0;i<n;i++)
			A[i]=s.nextInt();
		Heap h=new Heap(A);
		new HeapSort().heapSort(new Heap(new int[]{}).buildMaxHeap(h));
	}
	void heapSort(Heap h)
	{
		System.out.print("The elements in non-increasing order are: ");
		Heap temp=new Heap(new int[]{});
		for(int i=h.A.length-1;i>0;i--)
		{
			int tmp=h.A[0];
			h.A[0]=h.A[h.heapSize-1];
			h.A[h.heapSize-1]=tmp;
			h.heapSize-=1;
			temp.maxHeapify(h,0);
		}
		for(int x:h.A)
			System.out.print(x+"\t");
		System.out.println();
	}
}