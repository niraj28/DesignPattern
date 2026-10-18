package string;

public class ValidAnagram {
	/*
	 * This is a frequency counting problem.
	 * Approach:  counting characters.
	   Complexity
		       Time: O(n)
		       Space: O(1) since charset is fixed (26 lowercase letters)
	 */
	
	   public boolean isAnagram(String s, String t) {
	        if (s.length() != t.length()) return false;

	        int[] count = new int[26];

	        for (int i = 0; i < s.length(); i++) {
	            count[s.charAt(i) - 'a']++;
	            count[t.charAt(i) - 'a']--;
	        }

	        for (int c : count) {
	            if (c != 0) return false;
	        }

	        return true;
	    }
	   
	   public static void main(String[] args) {
		   			   
		   ValidAnagram solution = new ValidAnagram();
		   
		   String s1 = "anagram";
		   String t1 = "nagaram";
		   System.out.println(solution.isAnagram(s1, t1)); // Output: true
		   
		   String s2 = "rat";
		   String t2 = "car";
		   System.out.println(solution.isAnagram(s2, t2)); // Output: false
		   
		   String s3 = "listen";
		   String t3 = "silent";
		   System.out.println(solution.isAnagram(s3, t3)); // Output: true
		   }

}
