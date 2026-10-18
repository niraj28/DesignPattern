package string;

import java.util.Stack;

public class ValidParentheses {
	/* Approach:  Stack.
	   Time complexity
		       Time: O(n) where n is length of string
		       Space: O(n) in worst case for stack
	*/
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // handle closing brackets
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
			ValidParentheses solution = new ValidParentheses();
		
		String s1 = "()";
		System.out.println(solution.isValid(s1)); // Output: true
		
		String s2 = "()[]{}";
		System.out.println(solution.isValid(s2)); // Output: true
		
		String s3 = "(]";
		System.out.println(solution.isValid(s3)); // Output: false	
	}

}
