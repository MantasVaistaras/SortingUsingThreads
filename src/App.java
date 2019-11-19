import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {	
		String threadCntString = "";
		String sourceFile = "";
		String outputFile;
		try {
			threadCntString = args[0];
			sourceFile = args[1];
			outputFile = args[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide 3 parameters in the command line - number of threads, source file name, output file name.");
			System.exit(0);
		}
		
		int threadCount;
		try {
			threadCount = Integer.parseInt(threadCntString);
		} catch (NumberFormatException e) {
			System.out.println("First parameter must be provided in the number format.");
		}
		
		readFile(sourceFile);
	}
	
	public static SourceFile readFile(String fileName) {
		Scanner in = null;
		try {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		int wordCount = Integer.parseInt(in.nextLine());
		String[] list = new String[wordCount];
		for (int i = 0; i < wordCount; i++) {
			list[i] = in.nextLine();
		}
		return new SourceFile(wordCount, list);
	}

	public String[] sort(String[] wordList) {
		
		
	}
}
