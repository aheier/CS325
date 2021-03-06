import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem3 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("Total number: \n");
		int size = getNumber(scnr);
		
		int[] numbers = new int[size];
		System.out.print("Numbers: \n");
		for(int i=0; i< size; i++) {
			numbers[i] = getNumber(scnr);
		}
		
		int idx = findFirstNonRepeating(numbers);
		System.out.println("First Non-repeating integer: "   + (idx!=0 ? idx : "None"));
		
		
		scnr.close();
	}
	
	public static int getNumber(Scanner scnr) {
		int in;
		while(true) {
			try {
				in = scnr.nextInt();
				break;
			}
			catch(InputMismatchException e) {
				System.out.println("Bad input");
				scnr.next();
			}
		}
		return in;
	}
	
	public static int findFirstNonRepeating(int[] arr) {
		int i;
		int n = arr.length;
	    for (i = 0; i < n; i++)
	    {
	        for (int j = 0; j <= n; j++)
	        {
	            if (j == n)
	            {
	                return arr[i];
	            }
	            if (j != i && arr[i] == arr[j])
	            {
	                break;
	            }
	        }
	    }
	    return 0;
	}
}
