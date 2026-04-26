package string;

public class MinimumWindowSubstring {

	/*
	 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.

	 */
	
	public String minWindow(String s, String t) {

        // Edge case: if s is smaller than t, impossible
        if (s.length() < t.length()) return "";

        // Frequency array to store required characters from t
        int[] need = new int[128];

        // Fill frequency for t
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;                     // left pointer of window
        int required = t.length();        // total chars still needed

        int minLen = Integer.MAX_VALUE;   // store smallest window length
        int start = 0;                    // starting index of answer

        // Expand window using right pointer
        for (int right = 0; right < s.length(); right++) {

            char rightChar = s.charAt(right);

            // If this char is needed, reduce required count
            if (need[rightChar] > 0) {
                required--;
            }

            // Decrease freq (even if extra char, goes negative)
            need[rightChar]--;

            // When all characters are matched
            while (required == 0) {

                int windowSize = right - left + 1;

                // Update minimum window if smaller found
                if (windowSize < minLen) {
                    minLen = windowSize;
                    start = left;
                }

                char leftChar = s.charAt(left);

                // Put the left char back into need array
                need[leftChar]++;

                // If it becomes > 0 → we lost a required char
                if (need[leftChar] > 0) {
                    required++;   // window is no longer valid
                }

                left++; // shrink window from left
            }
        }

        // If no valid window found, return ""
        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
	
	public static void main(String[] args) {
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		System.out.println(mws.minWindow("ADOBECODEBANC", "ABC")); // Output: "BANC"
		System.out.println(mws.minWindow("a", "a")); // Output: "a"
		System.out.println(mws.minWindow("a", "aa")); // Output: ""
	}
}
