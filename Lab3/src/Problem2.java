import java.util.Scanner;

public class Problem2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i < 8; i++) {
			System.out.printf("Wrong guess %s\n", i);
			printMan(i);
		}
		
		System.out.println("How many wrong guesses? ");
		int guesses = sc.nextInt();
		
		
		printMan(guesses);
		
	}
	
	
	public static void printMan(int val) {
		System.out.println("_______");
		System.out.printf(" |   | \n");
		System.out.printf(" |   %s \n", (val < 1 ? " " : "O"));
		System.out.printf(" |  %s%s%s \n", (val < 3 ? " " : "/"),(val < 2 ? " " : "|"),(val < 4 ? " " : "\\"));
		System.out.printf(" |   %s \n", (val < 5 ? " " : "|"));
		System.out.printf(" |  %s %s \n", (val < 6 ? " " : "/"), (val < 7 ? " " : "\\"));
	}
}
