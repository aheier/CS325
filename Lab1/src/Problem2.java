import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String[] input = new String[10];
		String currentLine;
		int i=0;
		
		while(scnr.hasNextLine()) {
			currentLine = scnr.nextLine();
			//System.out.println(currentLine);
			if(currentLine.equals("DONE")) {
				//System.out.println("here");
				break;
			}
			input[i++] = currentLine;
		}
		for(String s : input) {
			if(s == null)
				break;
			//System.out.println(s);
			printIsPalindrome(s);
		}
		scnr.close();
	}
	
	public static boolean isPalindrome(String line) {
		line = line.toLowerCase().replaceAll("[\\W\\.\\?,!]", "");
		//System.out.println(line);
		int length = line.length()-1;
		for(int i=0; i< length/2; i++) {
			//System.out.println(line.charAt(i) + " : " +  line.charAt(length -i));			
			if(line.charAt(i) != line.charAt(length -i))
				return false;
		}
		return true;
	}
	
	public static void printIsPalindrome(String line) {
		if(isPalindrome(line)) {
			System.out.println("You won't be eaten!");
			return;
		}
		System.out.println("Uh oh..");
	}
	/*
	 * Madam, Im adam!
	 * Roma tibi subito motibus ibit amor.
	 * Me so hungry!
	 * Si nummi immunis
	 * DONE
	 */

}
