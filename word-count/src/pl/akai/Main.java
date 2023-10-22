package pl.akai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String[] sentences = {
            "Taki mamy klimat",
            "Wszędzie dobrze ale w domu najlepiej",
            "Wyskoczył jak Filip z konopii",
            "Gdzie kucharek sześć tam nie ma co jeść",
            "Nie ma to jak w domu",
            "Konduktorze łaskawy zabierz nas do Warszawy",
            "Jeżeli nie zjesz obiadu to nie dostaniesz deseru",
            "Bez pracy nie ma kołaczy",
            "Kto sieje wiatr ten zbiera burzę",
            "Być szybkim jak wiatr",
            "Kopać pod kimś dołki",
            "Gdzie raki zimują",
            "Gdzie pieprz rośnie",
            "Swoją drogą to gdzie rośnie pieprz?",
            "Mam nadzieję, że poradzisz sobie z tym zadaniem bez problemu",
            "Nie powinno sprawić żadnego problemu, bo Google jest dozwolony"
    };

    public static void main(String[] args) {   	
    	HashMap<String, Integer> wordsInSentences = new HashMap<>();
    	prepareWords(wordsInSentences);
    	
    	ArrayList<Map.Entry<String, Integer>> listOfWords = new ArrayList<>(wordsInSentences.entrySet());
    	listOfWords.sort((a, b) -> b.getValue().compareTo(a.getValue()));
    	
        for (int i = 0; i < Math.min(3, listOfWords.size()); i++)
            System.out.println(i+1 + ". \"" + listOfWords.get(i).getKey() + "\" - " + listOfWords.get(i).getValue());
    }

	private static void prepareWords(HashMap<String, Integer> wordsInSentences) {
		for(String s : sentences) {
    		String[] wordsInSentence = s.split("\\s+");
    		for(String word: wordsInSentence) {
    			word = word.toLowerCase().replaceAll("[^a-zA-ZĄąĆćĘęŁłŃńÓóŚśŹźŻż]", "");
				if (wordsInSentences.containsKey(word))
					wordsInSentences.put(word, wordsInSentences.get(word) + 1);
		        else
		        	wordsInSentences.put(word, 1);
    			}
		}
	}
}
