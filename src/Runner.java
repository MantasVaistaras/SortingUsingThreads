
public class Runner extends Thread{
	
	private String[] array;
	private Monitor monitor;
	
	public Runner(String[] array, Monitor monitor) {
		this.array = array;
		this.monitor = monitor;
	}
	
	public void run() {
		App.QuickSort(0, this.array.length-1, this.array);
		TwoArrays twoSortedArrays = monitor.takeSortedArray(this.array);
		while(twoSortedArrays != null) {
			this.array = merge(twoSortedArrays.getFirsSortedArray(), twoSortedArrays.getSecondSortedArray());
			twoSortedArrays = monitor.takeSortedArray(this.array);
		}	
	}
	
	public String[] merge(String[] array1, String[] array2) {
		//method which merges two sorted arrays and returns one sorted array
		String[] array = new String[(array1.length+array2.length)];
		int j = 0;
		int n = array2.length;
		for (int i = 0; i < array1.length; i++) {
			if( j < n) {
				if(array1[i].compareTo(array2[j]) <= 0) {
					array[i+j] = array1[i];
				}else{
					array[i+j] = array2[j];
					j++;
				}			
			} else {
				array[i+j] = array1[i];
			}			
		}
		if(j < n) {
			for(int i = j; i < n; i++) {
				array[array1.length+i] = array2[i];
			}
		}
		return array;
	}
}
