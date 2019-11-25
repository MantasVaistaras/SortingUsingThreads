
public class Monitor {
	
	private String[] firstSortedArray = null;
	private String[] secondSortedArray = null;
	private String[] connectedArray = null;
	
	public synchronized void takeSortedArray(String[] array) {
		if(this.firstSortedArray == null) {
			this.firstSortedArray = array;
		}
		else if( this.secondSortedArray == null) {
			this.secondSortedArray = array;
			/*
			this.connectedArray = new String[(this.firstSortedArray.length+this.secondSortedArray.length)];
			System.arraycopy(this.firstSortedArray, 0, this.connectedArray, 0, this.firstSortedArray.length);
			System.arraycopy(this.secondSortedArray, 0, this.connectedArray, this.firstSortedArray.length, this.secondSortedArray.length);
			this.firstSortedArray = null;
			this.secondSortedArray = null;
			*/
		}
	}
	
	public String[] getFirstSortedArray() {
		return this.firstSortedArray;
	}
	
	public String[] getSecondSortedArray() {
		return this.secondSortedArray;
	}
	

}
