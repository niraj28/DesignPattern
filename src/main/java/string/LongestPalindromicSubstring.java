package string;

public class LongestPalindromicSubstring {
	
	/*
	 * Approach:  Expand Around Center.
	   Time complexity
		       Time: O(n^2) where n is length of string
		       Space: O(1)
		       
		Best Optimal- Manacher's Algorithm: O(n) time and O(n) space, but more complex to implement.
	 */

	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);       // odd length
            int len2 = expand(s, i, i + 1);   // even length
            int len = Math.max(len1, len2);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
		
		LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
		
		String s1 = "babad";
		System.out.println(solution.longestPalindrome(s1)); // Output: "aba" or "bab"
		
		String s2 = "cbbd";
		System.out.println(solution.longestPalindrome(s2)); // Output: "bb"
		
		String s3 = "a";
		System.out.println(solution.longestPalindrome(s3)); // Output: "a"
		
		String s4 = "ac";
		System.out.println(solution.longestPalindrome(s4)); // Output: "a" or "c"
	}
    
}
