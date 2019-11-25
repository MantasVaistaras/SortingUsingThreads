
public class Runner extends Thread{
	
	private String[] array;
	private Monitor monitor;
	
	public Runner(String[] array, Monitor monitor) {
		this.array = array;
		this.monitor = monitor;
	}
	
	public void run() {
		App.QuickSort(0, this.array.length-1, this.array);
		monitor.takeSortedArray(this.array);
		//wait until the monitor has two sorted arrays ready
		String[] array1 = monitor.getFirstSortedArray();
		String[] array2 = monitor.getSecondSortedArray();
	}
	
	/*
	public String[] mergeArrays(String[] array1, String[] array2) {
		
	}
	*/
}
