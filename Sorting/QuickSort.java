
public class QuickSort{
	
	//private int[] data = new int[]{15,13,14,12,10,11,7,9,8,1,3,2,4,6,5};
	//private int[] data = new int[]{6,6,5,4,5,7,8,8,8,10,12,0,3,2,4,6,9,9,9,2,3,4,5};
	//private int[] data = new int[]{2,3,3};
	//private int[] data = new int[]{8,7,5,4,6};
	private int[] data = new int[]{ 6, 4, 2, 3, 1, 7};
	//private int[] data = new int[]{2,4,5,3,6};

	public QuickSort()
	{
	}

	public void sort()
	{
		sort(data, 0, data.length-1);
		print();
	}

	public void sort( int[] data , int leftBorder, int rightBorder)
	{

		System.out.println("leftBorder: "+data[leftBorder]+" rightBorder: "+data[rightBorder]);
		int pivot = (rightBorder+leftBorder)/2;
		
		int pivotV = data[pivot];
		System.out.println("Pivot "+pivotV);

		// We need to move the left and right pointers but we can't lose them so let's make a copy of them.
		int left = leftBorder;
		int right = rightBorder;

		while(left<right)
		{
			while(data[left]<pivotV)
			{
				left++;
			}

			while(data[right]>pivotV)
			{
				right--;
			}

			if(left<right)
			{
				System.out.println("Switching: "+data[left]+" with "+data[right]);
				int temp = data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
		}

		// We keep track of the pivot because it could have moved around in one of the switchs
		pivot=left;

		System.out.println("Exited when left: "+data[left]+" and right: "+data[right]);
		System.out.println("Finished partition: ");
		print(leftBorder,rightBorder);
		if(leftBorder<(pivot-1))
		{
			System.out.println("Going Left");
			sort(data, leftBorder, pivot-1);
		}
		if((pivot+1)<rightBorder)
		{
			System.out.println("Going Right");
			sort(data, pivot, rightBorder+1);
		}	
		print();

	}




















	public int partition(int arr[], int left, int right)
	{
	      int i = left, j = right;
	      int tmp;
	      int pivot = arr[(left + right) / 2];
	     // System.out.println("leftBorder: "+data[i]+" rightBorder: "+data[j]);
	      //System.out.println("Pivot: "+pivot);
	     
	      while (i <= j) {
	            while (arr[i] < pivot)
	                  i++;
	            while (arr[j] > pivot)
	                  j--;
	            if (i <= j) {
	            		//System.out.println("Switching: "+data[i]+" with "+data[j]);
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };
	     	print();
	     	//System.out.println("Returning: "+data[i]);
	      return i;
	}
	 
	public void quickSort(int arr[], int left, int right) {
	      int index = partition(arr, left, right);
	      if (left < index - 1)
	            quickSort(arr, left, index - 1);
	      if (index < right)
	            quickSort(arr, index, right);
	        print();
	}

	public void sort2()
	{
		quickSort(data,0,data.length-1);
		print();
	}

	public void print()
	{
		print(0,data.length-1);
	}

	public void print(int left, int right)
	{
		for(int i = left ; i < right+1;i++)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println("");
	}
}