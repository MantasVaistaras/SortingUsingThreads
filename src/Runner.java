
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
		if(twoSortedArrays != null) {
			merge(twoSortedArrays.getFirsSortedArray(), twoSortedArrays.getSecondSortedArray());
		}	
	}
	
	public static String[] merge() {
		//method which merges two sorted arrays and returns one sorted array
	}
	
}
