import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class file {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Anthony Heier\\Downloads\\example.txt");
		
		if(! file.exists()) {
			System.out.println("File does not exist");
			return;
		}
		System.out.println("File Exists");
		
		try {
			FileWriter myWriter = new FileWriter("example.txt");
			BufferedWriter buffer = new BufferedWriter(myWriter);
			buffer.write("Hello\n");
			buffer.write("CS325 sucks");
			buffer.write("CS325 sucks");
			buffer.close();
			
		}
		catch(IOException ex) {
			System.out.println("Error happened while reading the file");
		}
	}

}
