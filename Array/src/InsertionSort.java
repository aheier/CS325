
public class InsertionSort {
	public static void main(String[] args) {
		int[] array = { 28, 28, 17, 12, 6, 0, 0, 5, 4, 3, 2, 1 };
		
		for(int i=1; i<array.length; i++) {
			int curr = array[i];
			int j = i-1;
			while(j >=0 && array[j]>=curr) {
				array[j+1] = array[j];
				--j;
			}
			array[j+1] = curr;
		}
		
		for(int b : array) {
			System.out.println(b);
		}
		
	}
	
}
