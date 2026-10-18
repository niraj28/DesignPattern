package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	/* Approach:  HashMap + sorting.
	   Time complexity
		       Time: O(n * k log k) where n is number of strings and k is max length of a string
		       Space: O(n * k) for the output list and hashmap
	*/
	public List<List<String>> groupAnagrams(String[] strs) {
	
	   Map<String, List<String>> map = new HashMap<>();

       for (String str : strs) {
           char[] arr = str.toCharArray();
           Arrays.sort(arr);
           String key = new String(arr);

           map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
       }

       return new ArrayList<>(map.values());
	}
	
	public static void main(String[] args) {
		GroupAnagrams solution = new GroupAnagrams();
		
		String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(solution.groupAnagrams(strs1)); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		
		String[] strs2 = {""};
		System.out.println(solution.groupAnagrams(strs2)); // Output: [[""]]
		
		String[] strs3 = {"a"};
		System.out.println(solution.groupAnagrams(strs3)); // Output: [["a"]]
	}

}
