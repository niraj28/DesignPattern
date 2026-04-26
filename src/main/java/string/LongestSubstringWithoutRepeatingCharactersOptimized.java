package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharactersOptimized {
	/*
	 * 	Approach:  sliding window + HashMap.
	   Complexity
		       Time: O(n)
		       O(min(n, charset size))
	 */
	
	  public int lengthOfLongestSubstring(String s) {
	
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);

        if (map.containsKey(ch)) {
            left = Math.max(left, map.get(ch) + 1);
        }

        map.put(ch, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
	  public static void main(String[] args) {
		  	
		  LongestSubstringWithoutRepeatingCharactersOptimized solution = new LongestSubstringWithoutRepeatingCharactersOptimized();
		  	
		  String s1 = "abcabcbb";			
		  
		  System.out.println(solution.lengthOfLongestSubstring(s1)); // Output: 3
		  		
	  }

}
