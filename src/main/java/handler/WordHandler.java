package handler;

import java.util.ArrayList;
import java.util.List;

public class WordHandler {
	public static List<String> splitSentences(String sentences) {

		List<String> listWord = new ArrayList<>();
		String[] tu = sentences.split("[\\p{Punct}\\s]+");
		for (String s : tu) {
			listWord.add(s);
		}
		return listWord;

	}

}
