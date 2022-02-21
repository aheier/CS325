import java.util.Scanner;

public class Problem1 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userInput;
		
		System.out.println("Enter in the size of the Queue");
		int size = scnr.nextInt();
		CircularQueue q = new CircularQueue(size);
		
		
		do {
			printMenu();
			userInput = scnr.nextInt();
			switch(userInput) {
			case 1:
				System.out.print("Number to add: ");
				try {
					q.add(scnr.nextInt());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {
					System.out.println("Current Item " + q.poll());
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				q.displayAll();		
				break;
			}
		}
		while(userInput !=0);
		scnr.close();
	}
	
	
	public static void printMenu() {
		System.out.println("----------Circular Queue----------");
		System.out.println("-- 1. Add           2. Remove   --");
		System.out.println("-- 3. Display All   0. Exit     --");
		System.out.println("----------------------------------");
	}
}
