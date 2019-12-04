
public class Monitor {
	
	private String[] firstSortedArray = null;
	
	public synchronized TwoArrays takeSortedArray(String[] array) {
		TwoArrays twoArrays;
		if(this.firstSortedArray == null) {
			this.firstSortedArray = array;
			return null;
		}
		else{
			twoArrays = new TwoArrays(this.firstSortedArray, array);
			this.firstSortedArray = null;
			return twoArrays;
		}
	}
	
	public String[] getArray() {
		return this.firstSortedArray;
	}
	
}
