
public class MergeSort {
	public static int[] recursiveMergeSort(int[] arr1, int[] arr2, int[] newArr,
			int i, int j, int k) {
		if(i < arr1.length && j <  arr2.length) {
			if(arr1[i] < arr2[j]) {
				newArr[k++] = arr1[i++];
			}
			else{
				newArr[k++] = arr2[j++];
			}
			recursiveMergeSort(arr1, arr2, newArr, i, j, k);
		}
		else{//if arr1 has left over members			
			while(i < arr1.length) {
				newArr[k++] = arr1[i++];
			}
			// if arr2 has left over members
			while(j <  arr2.length) {
				newArr[k++] = arr2[j++];
			}
		}
		return newArr;
	}
	
	public static void main(String[] args) {
		int arr1[] = {1, 3, 5, 7, 9, 11, 13, 15};
		int arr2[] = {2, 4, 6, 8, 10, 12};
		
		int newArr[] = new int[arr1.length + arr2.length];
		
		recursiveMergeSort(arr1, arr2, newArr, 0, 0, 0);
		for(int n : newArr) {
			System.out.print(n + " ");
		}
	}

}
