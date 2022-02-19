class OrdededArray {
	private long[] a;
	private int nElems;

	public OrdededArray(int max) // constructor
	{
		a = new long[max]; // create array
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	// This is a binary search
	// Find the location/index of the search item
	public int locate(long searchKey) {
		int lowerIndex = 0;
		int upperIndex = nElems - 1;
		int midIndex;

		while (upperIndex >= lowerIndex) {
			midIndex = (lowerIndex + upperIndex) / 2; // middle
			if (a[midIndex] == searchKey) { // is it there?
				return midIndex; // yes, return index
			}
			if (a[midIndex] < searchKey) {
				lowerIndex = midIndex + 1; // it's in upper half
				continue;
			}
			upperIndex = midIndex - 1; // it's in lower half
		}
		return lowerIndex;
	}

	public int find(long searchKey) {
		int j = locate(searchKey); 
		if (a[j] == searchKey) {
			return j; 
		}
		return nElems; 
	} 

	public void insert(long value) {
		int index = locate(value);
		for (int j = nElems; j > index; j--) {
			a[j] = a[j-1];
		}
		a[index]=value;
		nElems++;
	}

	public boolean delete(long searchKey) {
		int index = find(searchKey);
		if(a[index] == searchKey) 
			return false;
		for(int j = index; j < nElems-1; j++) {
			a[j] = a[j+1];
		}
		nElems--;
		return true;
	}

	public void display() {
		for (int j = 0; j < nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}
}