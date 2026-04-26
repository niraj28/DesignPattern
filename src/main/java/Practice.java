

public class Practice {
/*
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

	Return the length of the longest substring containing the same letter you can get after performing the above operations.
	
	 
	
	Example 1:
	
	Input: s = "ABAB", k = 2
	Output: 4
	Explanation: Replace the two 'A's with two 'B's or vice versa.
	Example 2:
	
	Input: s = "AABABBA", k = 1
	Output: 4
	Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
	The substring "BBBB" has the longest repeating letters, which is 4.
	There may exists other ways to achieve this answer too.
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Sliding Window + Frequency Count (Greedy) approach.
 * 1. Use a sliding window (left, right)
   2. Maintain a frequency[] array for characters
   3.Track maxFrequency (most frequent char in current window)
   4.Expand window (right++)
	
   5.If:
	
	(window size - maxFrequency) > k
	
	→ shrink window (left++)
	
   6.Keep updating maxLength
 * 
 */
}
