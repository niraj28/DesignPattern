package string;

public class ValidPalindrome {
	/*
	 * Approach:  Two pointers.
	   Time complexity
		       Time: O(n) where n is length of string
		       Space: O(1)
	 */
	
	public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // skip non-alphanumeric
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // compare (case insensitive)
            if (Character.toLowerCase(s.charAt(left)) != 
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
	public static void main(String[] args) {
		
		ValidPalindrome solution = new ValidPalindrome();
		
	 		String	 s1 = "	A ma  n, a plan, a canal: Panama  ";
	 		System.out.println(solution.isPalindrome(s1)); // Output: true
	 		
	 		String s2 = "race a car";
	 		System.out.println(solution.isPalindrome(s2)); // Output: false
	 		
				
	}
}
