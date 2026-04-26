package string;

public class LongestRepeatingCharacterReplacement {
	/*
	 * sliding window + greedy optimization problem.
	 * 🔑 Core Idea

	Inside any window:
	
	Let:
	windowSize = right - left + 1
	maxFrequency = count of most frequent char in that window
	
	👉 Then:
	
	Replacements needed = windowSize - maxFrequency
	
	
		 */
	
	public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];

        int left = 0;
        int maxFrequency = 0;   // highest frequency of a single char in window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);
            frequency[currentChar - 'A']++;//It increments the count (frequency) of the current character in the window.

            // track the most frequent character in current window
            maxFrequency = Math.max(maxFrequency, frequency[currentChar - 'A']);

            int windowSize = right - left + 1;

            // if replacements needed > k, shrink window
            while (windowSize - maxFrequency > k) {
                char leftChar = s.charAt(left);
                frequency[leftChar - 'A']--;
                left++;
                windowSize = right - left + 1; // update after shrinking
            }

            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
	
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement solution = new LongestRepeatingCharacterReplacement();
		
		String s1 = "ABAB";
		int k1 = 2;
		System.out.println(solution.characterReplacement(s1, k1)); // Output: 4
		
		String s2 = "AABABBA";
		int k2 = 1;
		System.out.println(solution.characterReplacement(s2, k2)); // Output: 4
	}

}
