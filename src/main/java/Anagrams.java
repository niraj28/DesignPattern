import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Anagrams {
	
/*	3. You are given a list of words in dictionary, and a list of input words, Find all the anagrams of input words from dictionary.

	dictwords =  ["cat", "dog", "tac", "god", "act"] 

	inputwords = ["cat" , "bat"]


	Output : cat -> ["cat", "tac", "act"]
	                bat -> [] */
	
	public static void main(String[] args) {
		
String[] dict = {"cat", "dog", "tac", "god", "act"};

String[] inputWords = {"cat", "bat"};

HashMap<String, ArrayList<Integer>> map = new HashMap<>();
ArrayList<Integer> list;
int i = -1;

for (String str : dict) {
    char[] s = str.toCharArray();
    i++;
    Arrays.sort(s);

    String key = new String(s);

    if (map.containsKey(key)) {
        list = map.get(key);
        list.add(i);
    } else {
        list = new ArrayList<>();
        list.add(i);
        map.put(key, list);
    }
}

for (String fr : inputWords) {
    char[] f = fr.toCharArray();
    Arrays.sort(f);

    String key = new String(f);

    System.out.print(fr + " -> ");

    if (map.containsKey(key)) {
        list = map.get(key);
        ArrayList<String> result = new ArrayList<>();
        for (int l : list) {
            result.add(dict[l]);
        }
        System.out.println(result);
    } else {
        System.out.println("[]");
    }
}
}
}
