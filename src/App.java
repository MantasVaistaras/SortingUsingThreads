import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {	
		String threadCntString = "";
		String file = "";
		String outputFile;
		try {
			threadCntString = args[0];
			file = args[1];
			outputFile = args[2];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Please provide 3 parameters in the command line - number of threads, source file name, output file name.");
			System.exit(0);
		}
		
		int threadCount = 0;
		try {
			threadCount = Integer.parseInt(threadCntString);
		} catch (NumberFormatException e) {
			System.out.println("First parameter must be provided in the number format.");
		}
		SourceFile sourceFile = readFile(file);
		int wordCount = sourceFile.getWordCount();
		String[] list = sourceFile.getWordList();
		//QuickSort(0, list.length-1, list);
		
		/*Implementing multi-threading. Each thread will have to sort n = wordCount/threadCount(+-1) words.
		 * the number of threads that will sort n+1 words x = wordCount%threadCount
		 * the number of threads that will sort n words y = threadCount - x
		 */
		int x = wordCount%threadCount;
		int y = threadCount - x;
		int n = wordCount/threadCount;
		for (int i = 0; i < y; i++) {
			String[] array = new String[n];
			System.arraycopy(list, i*n, array, 0, n);
			System.out.println();
			System.out.println("Array number " + i + " with a length " + n);
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j]);
			}
		}
		for (int i = 0; i < x; i++) {
			String[] array = new String[n+1];
			System.arraycopy(list, (y*n + (i*(n+1))), array, 0, (n+1));
			System.out.println();
			System.out.println("Array number " + y+i + " with a length " + (n+1));
			for (int j = 0; j < array.length; j++) {
				System.out.println(array[j]);
			}
		}
		
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
	
	public static void QuickSort(int low, int high, String[] wordList) {
		// implementing Quick Sort algorithm		
		String pivot = wordList[high];
		int i = low - 1;
		String temp;
		if((high - low) > 0) {
			//there is more than one element in the partitioning array
			for(int j = low; j < high; j++) {
				if(wordList[j].compareTo(pivot) < 0) {
					//wordList[j] is lexicographically preceding the pivot
					i++;
					temp = wordList[i];
					wordList[i] = wordList[j];
					wordList[j] = temp;
				}			
			}
			//found the pivot position = i+1. Every element after the index i must be equal or bigger than the pivot
			temp = wordList[i+1];
			wordList[i+1] = pivot;
			wordList[high] = temp;
			if((i+1-low) >= 2) {
				//there are more than one element to the left of the pivot
				QuickSort(low, i, wordList);
			}
			if((high - (i+1)) >= 2) {
				//there are more than one element to the right of the pivot
				QuickSort(i+2, high, wordList);
			}
		}
	
	}
}
