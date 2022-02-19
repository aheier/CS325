import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Hello {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String line = scnr.nextLine();
		System.out.println(line);
		
		char[] charArray = line.toCharArray();
		char[] newArray = replaceSpace(charArray);
		System.out.println(String.valueOf(newArray));
		
		scnr.close();
	}
	
	public static char[] replaceSpace(char[] charArray) {
		int count =0;
		for(char c : charArray) {
			if (c == ' ') count++;
		}
		char[] newArray = new char[charArray.length + count * 2];
		int newIdx = 0;
		for(int idx=0; idx< charArray.length; idx++) {
			if (charArray[idx] == ' ') {
				newArray[newIdx++] = '%';
				newArray[newIdx++] = '2';
				newArray[newIdx++] = '0';
				continue;
			}
			newArray[newIdx++] = charArray[idx];
		}
		return newArray;
	}

}
