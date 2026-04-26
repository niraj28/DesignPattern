package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagramsOptimal {
	/* Approach:  HashMap + character count.
	   Time complexity
		       Time: O(n * k) where n is number of strings and k is max length of a string
		       Space: O(n * k) for the output list and hashmap
	*/
	
	public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];

            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for (int c : count) {
                key.append("#").append(c);
            }

            String mapKey = key.toString();

            if (!map.containsKey(mapKey)) {
                map.put(mapKey, new ArrayList<>());
            }

            map.get(mapKey).add(str);
        }

        return new ArrayList<>(map.values());
        
    }
	
	public static void main(String[] args) {
		GroupAnagramsOptimal solution = new GroupAnagramsOptimal();
		
		String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(solution.groupAnagrams(strs1)); // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
		
		String[] strs2 = {""};
		System.out.println(solution.groupAnagrams(strs2)); // Output: [[""]]
		
		String[] strs3 = {"a"};
		System.out.println(solution.groupAnagrams(strs3)); // Output: [["a"]]
		}

}
