final class SourceFile {
	
	private int wordCount;
	private String[] wordList;
	
	public SourceFile(int wordCount, String[] list) {
		this.wordCount = wordCount;
		this.wordList = list;
	}
	
	public int getWordCount() {
		return wordCount;
	}
	
	public String[] getWordList() {
		return wordList;
	}
}
