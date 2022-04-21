package lab2;

public class Word {

	private String theWord;
	private int counts;
	private static int outputFormat;

	public Word(String word) {
		theWord = word;
		counts = 1;
	}

	public String getWord() {
		return theWord;
	}

	public int getCounts() {
		return counts;
	}

	public void increaseCounts() {
		counts = counts + 1;
	}

	public static void changeOutputFormat(int arg) {
		if (arg == 0) outputFormat = 0;
		if (arg != 0) outputFormat = 1;
	}

	public String toString() {
		if (outputFormat == 1) return "The word is : " + theWord;
		else {
			return "The word " + theWord + " has occured " + counts + " times";
		}
	}
}
///Users/isakgreatrex/Downloads/Lab2/Sourcetext.txt
