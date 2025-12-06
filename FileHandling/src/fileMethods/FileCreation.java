package fileMethods;
import java.util.*;
import java.io.*;
public class FileCreation {
	public static void main(String[] args) {
		File file = new File("MyFirst.txt");
		try {
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("Hi this is my first text file");
		fileWriter.close();
		FileReader fileReader = new FileReader(file);
		int myChar = -1;
		while((myChar=fileReader.read())!=-1) {
			System.out.print((char)myChar);
		}
		fileReader.close();
		System.out.println();
		} catch(IOException e) {
			System.out.println("An error occurred: " + e.getMessage());
		}
		
	}
}
