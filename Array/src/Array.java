class Array {
	private long[] a; 
	private int nElems; // number of data items

	public Array(int max) // constructor
	{
		a = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	public long getMax() {
		long max = Long.MIN_VALUE;
		for (int j = 0; j < nElems; j++) {
			if (a[j] > max) {
				max = a[j]; 
			}
		}
		return max;
	}

	public boolean find(long searchKey) { 
		for (int j = 0; j < nElems; j++) {
			if (a[j] == searchKey) {
				return true;
			}
		}
		return false;
	}

	public void insert(long value) // put element into array
	{
		a[nElems] = value; // insert it
		nElems++; // increment size
	}

	public boolean delete(long value) {
		for(int i=0; i<nElems; i++) {
			if(a[i] == value) {
				for(int j = i; j < nElems-1; j++) {
					a[j] = a[j+1];
				}
				nElems--;
				return true;
			}
		}
		return false;
		
	}

	public void display() // displays array contents
	{
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}
	

	
	public void bubbleSort() {
		long temp;
		boolean isSorted;
		for(int i=0; i< nElems; i++) {
			isSorted=true;
			for(int j=0; j < nElems-1-i; j++) {
				if(this.a[j] > this.a[j+1]) {
					temp = this.a[j];
					this.a[j] = this.a[j+1];
					this.a[j+1] = temp;
					isSorted = false;
				}
			}
			if (isSorted == true)
				break;
			display();
		}
	}
	
	public void selectionSort() {
		int min;
		long swap;
		for(int i=0; i<nElems; i++) {
			min = i;
			for(int j =i+1; j<nElems; j++) {
				if(a[min] < a[j]) {
					min = j;
				}
			}
			swap = a[i];
			a[i] = a[min];
			a[min] = swap;
		}
	}
	
	public void insertionSort() {
		
	}
}