import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Distance ? ");
		int size = scnr.nextInt();
		int front=0;
		int back = size-1;
		for(int i =0; i< size; i++) {
			for(int j =0; j< size; j++) {
				if(j == front ) {
					System.out.print("#");
					continue;
				}
				if(j == back ) {
					System.out.print("#");
					continue;
				}
				System.out.print(" ");				
			}
			System.out.println();
			back--;
			front++;
		}
	}
}
