package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesesCleaner {
	/* Approach:  Stack + HashMap.
	   Time complexity
		       Time: O(n) where n is length of string
		       Space: O(n) in worst case for stack and hashmap
	*/
	
	public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
			ValidParenthesesCleaner solution = new ValidParenthesesCleaner();
	
		String s1 = "()";
		System.out.println(solution.isValid(s1)); // Output: true
		
		String s2 = "()[]{}";
		System.out.println(solution.isValid(s2)); // Output: true
		
		String s3 = "(]";
		System.out.println(solution.isValid(s3)); // Output: false
		
	}

}
