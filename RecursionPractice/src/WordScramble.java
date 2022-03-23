import java.util.Scanner;

public class WordScramble {
	public static void main(String[] args) {
	    Scanner sc = new Scanner (System.in);
	    String words = sc.nextLine();
	    System.out.println(words);
	    
	    //char[] letters = words.toCharArray();
	    recursive(words, "");
	}
	
	public static void recursive(String s1, String s2) {
		if(s1.length() == 0) {
			System.out.println(s2);
		}
		for(int i=0; i< s1.length(); i++) {
			recursive(s1.substring(0, i) + s1.substring(i+1, s1.length()),
					s1.charAt(i) + s2);
		}
	}
	
}
