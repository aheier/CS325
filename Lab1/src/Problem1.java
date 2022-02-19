import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		int time = -1, duration = -1;
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter current time: ");
		while(time < 0) {
			try {
				time = Integer.parseInt(scnr.next());
			}
			catch(NumberFormatException e) {
				System.out.println("Not Valid Input!");
			}
		}
		System.out.println("Enter your flight duration: ");
		while(duration < 0) {
			try {
				duration = Integer.parseInt(scnr.next());
			}
			catch(NumberFormatException e) {
				System.out.println("Not Valid Input!");
			}
		}
		
		System.out.println("Time: " + time + " - Duration: " + duration);
		int newTime = (time + duration) % 12;
		System.out.printf("You will reach at %s", newTime == 0 ? 12 : newTime);
		
		scnr.close();

	}

}
