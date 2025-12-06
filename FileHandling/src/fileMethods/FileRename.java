package fileMethods;
import java.util.*;
import java.io.*;
public class FileRename {
	public static void main(String[] args) {
		try {
		File file = new File("Essay.txt");
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("Today the sun rose quickly, painting the sky in shades of gold and pink.​\r\n"
				+ "A gentle breeze carried the scent of jasmine through open windows, filling the room with freshness.​\r\n"
				+ "Birds sang in the distance as a new day began, full of hope and possibilities.");
		fileWriter.close();
		BufferedReader bf = new BufferedReader(new FileReader("Essay.txt"));
		int lineCount = 0;
		int wordCount = 0;
		String line;
		while((line=bf.readLine())!=null) {
			lineCount++;
			wordCount+=line.trim().split("\\s+").length;
			System.out.println(line);
		}
		bf.close();
		FileWriter reportWriter = new FileWriter("report.txt");
        reportWriter.write("Total number of lines: " + lineCount + "\n");
        reportWriter.write("Total number of words: " + wordCount + "\n");
        reportWriter.close();
        System.out.println("Report generated successfully!");
        reportWriter.close();
		} catch(IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}
}
