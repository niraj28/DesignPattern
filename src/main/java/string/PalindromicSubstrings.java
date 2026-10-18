package string;

public class PalindromicSubstrings {
	/* Approach:  Expand around center.
   Time complexity		
		       Time: O(n^2) where n is length of string
		       Space: O(1)				
    */
	
	   public int countSubstrings(String s) {
	        int count = 0;

	        for (int i = 0; i < s.length(); i++) {
	            count += expand(s, i, i);       // odd-length palindromes
	            count += expand(s, i, i + 1);   // even-length palindromes
	        }

	        return count;
	    }

	    private int expand(String s, int left, int right) {
	        int count = 0;

	        while (left >= 0 && right < s.length()
	                && s.charAt(left) == s.charAt(right)) {
	            count++;
	            left--;
	            right++;
	        }

	        return count;
	    }
	    
	    public static void main(String[] args) {
	    	
	    	PalindromicSubstrings solution = new PalindromicSubstrings();
	    	
	    	String s1 = "abc";
	    	System.out.println(solution.countSubstrings(s1)); // Output: 3
	    	
	    	String s2 = "aaa";
	    	System.out.println(solution.countSubstrings(s2)); // Output: 6
	    	
	    	String s3 = "ababa";
	    	System.out.println(solution.countSubstrings(s3)); // Output: 9
	    }
	    
}
