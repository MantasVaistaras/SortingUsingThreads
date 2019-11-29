
public class Monitor {
	
	private String[] firstSortedArray = null;
	
	public synchronized TwoArrays takeSortedArray(String[] array) {
		if(this.firstSortedArray == null) {
			this.firstSortedArray = array;
			return null;
		}
		else{
			TwoArrays twoArrays = new TwoArrays(this.firstSortedArray, array);
			this.firstSortedArray = null;
			return twoArrays;
		}
	}
	
}
