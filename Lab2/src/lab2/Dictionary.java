package lab2;
import java.util.ArrayList;
public class Dictionary {

	private ArrayList<Word> theDictionary;
	
	public Dictionary() {
		theDictionary = new ArrayList<Word>();
	}
	
	public void addWords(String word) {
		String[] parts = word.split(" ");
		Word temp;
		for(int i = 0; i < parts.length; i ++) {
			temp = new Word(parts[i]);
			theDictionary.add(temp);
		}
	}
	
	public int numberOfWords() {
		return theDictionary.size();
	}
	
	public void removeDuplicates() {
		Word check;
		for (int i = 0; i < theDictionary.size(); i++) {
			check = theDictionary.get(i);
			for (int k = i+1; k < theDictionary.size(); k++) {
				if (check.getWord().equals(theDictionary.get(k).getWord())) {
					theDictionary.remove(k);
					k--;
					theDictionary.get(i).increaseCounts();
				}
			}
		}
	}
	
	public void sortDictionaryByCounts() {
		for(int i = 0; i < theDictionary.size(); i++) {
			for(int k = i+1; k < theDictionary.size(); k++) {
				Word tempCount2 = theDictionary.get(k);
				Word tempCount = theDictionary.get(i);
				if (tempCount2.getCounts() > tempCount.getCounts()) {
					theDictionary.set(i, tempCount2);
					theDictionary.set(k, tempCount);
				}
			}
		}
	}
	
	public void countOccurences() {
		removeDuplicates();
		sortDictionaryByCounts();
		if(!theDictionary.isEmpty()) {
			int occured = theDictionary.get(0).getCounts();
			int words = 1;
		for(int i = 0; i < theDictionary.size(); i++) {
			if(occured == theDictionary.get(i).getCounts()){
				words++;
			}else {
				System.out.println(String.format("%3d words occured %3d times", words, occured));
				words = 1;
				occured = theDictionary.get(i).getCounts();
			}
			  if (i+1 >= theDictionary.size()) {
                  System.out.println(String.format("%3d words occured %3d times", words, occured));
              }
			}
		  }
		}
	
	public String toString() {
		String result = " ";
		for (Word word : theDictionary) {
			result += word.toString() + "\n"; 
		}
		return result;
	}
}
