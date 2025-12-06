package fileMethods;
import java.util.*;
import java.io.*;
public class FileDemo {
	public static void main(String[] args) {
		File file = new File("file1.txt");
		File file1 = new File("file2.txt");
		try {
		FileWriter fw = new FileWriter(file);
		fw.write("The early morning air was crisp and filled with the sounds of chirping birds. "
				+ "Sunlight filtered softly through the swaying branches overhead. "
				+ "Each new day began with a quiet sense of possibility and peace. "
				+ "The old library was filled with the scent of aging paper and quiet whispers. "
				+ "Sunbeams streamed through dusty windows, casting patterns across the carpeted floor. Every shelf held stories waiting to be discovered by curious minds.");
		fw.close();
		FileWriter fw1 = new FileWriter(file1);
		fw1.write("When the rain poured outside, children gathered by the window to watch droplets race down the glass. "
				+ "Laughter filled the room as they made up stories about the tiny rivers forming. "
				+ "Cozy afternoons like these became cherished memories for everyone. On rainy evenings, families gathered around the dinner table to share laughter and warm soup. The gentle patter of drops on the roof created a rhythmic backdrop to friendly conversation. These moments wove memories that lingered long after the storm had passed.");
		fw1.close();
		BufferedReader reader1 = new BufferedReader(new FileReader("file1.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("file2.txt"));
        FileWriter writer = new FileWriter("merged.txt");
        
        String line1, line2;
        while (true) {
            line1 = reader1.readLine();
            line2 = reader2.readLine();

            if (line1 == null && line2 == null) break;

            if (line1 != null) {
                writer.write(line1 + "\n");
            }
            if (line2 != null) {
                writer.write(line2 + "\n");
            }
        }
        // Close all streams
        reader1.close();
        reader2.close();
        writer.close();
        System.out.println("Merge completed successfully!");
		} catch(IOException e) {
			System.out.println("An error occured: " + e.getMessage());
		}
	}
}
