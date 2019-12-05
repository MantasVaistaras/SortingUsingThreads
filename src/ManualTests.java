
public class ManualTests {
	
	public ManualTests(String[] finalSortedArray, int wordCount) {
		isTheSizeRight(finalSortedArray, wordCount);
		isTheLastElementNull(finalSortedArray);
		isItSorted(finalSortedArray);
	}

	private void isItSorted(String[] finalSortedArray) {
		// goes through all the elements and checks if the word in the place i is preceding the word in the place i+1
		for (int i = 0; i < (finalSortedArray.length-1); i++) {
			if(finalSortedArray[i].compareTo(finalSortedArray[i+1]) <= 0) {
				//OK
			}else {
				System.out.println("The array is not sorted! The element in the i position is not preceding the element in the i+1 position.");
				System.out.println("Where i = " + i);
				System.out.println("Word[i] = " + finalSortedArray[i]);
				System.out.println("Word[i+1] = " + finalSortedArray[i+1]);
				System.exit(0);
			}
		}
		System.out.println("The words are actually sorted. It works!");	
	}

	private void isTheLastElementNull(String[] finalSortedArray) {
		// checking if the last element is null or not (if program works - there should be no null in the end)
		int n = finalSortedArray.length;
		if(finalSortedArray[n-1] != null) {
			System.out.println("The last element is NOT null. Great!");
		}else {
			System.out.println("Last element is null. Something went wrong.");
		}	
	}

	private void isTheSizeRight(String[] finalArray, int wordCount) {
		// checks if the word count of the final sorted list is the same as in the provided list
		if(finalArray.length == wordCount) {
			System.out.println("The count of the words are matching.");
		}else {
			System.out.println("The count of the words is NOT matching.");
		}
	}
}
