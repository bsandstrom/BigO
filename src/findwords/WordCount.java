package findwords;

public class WordCount {
	private String word;
	private int occurances;
	
	public WordCount(String word){
		this.word = word;
		this.occurances = 1;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getOccurances() {
		return occurances;
	}
	public void increment() {
		this.occurances++;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass() == WordCount.class){
			if(((WordCount)obj).getWord().equals(this.word)){
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return word.hashCode();
	}

	@Override
	public String toString() {
		return word + " : " + occurances;
	}
	
	
}
