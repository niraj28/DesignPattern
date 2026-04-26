package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	
	/* Approach:  sliding window + HashSet.
	  Time complexity
			       Time: O(n)
			       Space: O(k) where k is size of charset in window 
    */
	
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
      int left = 0;
      int maxLen = 0;

      for (int right = 0; right < s.length(); right++) {
          char ch = s.charAt(right);

          while (set.contains(ch)) {
              set.remove(s.charAt(left));
              left++;
          }

          set.add(ch);
          maxLen = Math.max(maxLen, right - left + 1);
      }

      return maxLen;
  }
	
	public static void main(String[] args) {
		
		LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
		
		String s1 = "abcabcbb";
		System.out.println(solution.lengthOfLongestSubstring(s1)); // Output: 3
		
		String s2 = "bbbbb";
		System.out.println(solution.lengthOfLongestSubstring(s2)); // Output: 1
		
		String s3 = "pwwkew";
		System.out.println(solution.lengthOfLongestSubstring(s3)); // Output: 3
		}

}
