import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
	
/*	3. You are given a list of words in dictionary, and a list of input words, Find all the anagrams of input words from dictionary.

	dictwords =  ["cat", "dog", "tac", "god", "act"] 

	inputwords = ["cat" , "bat"]


	Output : cat -> ["cat", "tac", "act"]
	                bat -> [] */
	
	public static void main(String[] args) {
		
String[] dict = {"cat", "dog", "tac", "god", "act"};

String[] inputWords = {"cat", "bat"};

Map<String, List<String>> wordMap = new HashMap<>();


for(String s : dict) {
	

int[] count = new int[26];
	
	for(char c : s.toCharArray()) {
		count[c-'a']++;
	}
	
	StringBuilder key = new StringBuilder();
	for(int c: count) {
		key.append("#").append(c);
	}
	
	if(!wordMap.containsKey(key.toString())) {
		wordMap.put(key.toString(), new ArrayList<>());
	}
	wordMap.get(key.toString()).add(s);
	

		
	}

System.out.println( new ArrayList<>(wordMap.values()));
	
}
}
