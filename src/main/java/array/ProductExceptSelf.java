package array;

import java.util.Arrays;

public class ProductExceptSelf {
	
	/*
	 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
	 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
	 * You must write an algorithm that runs in O(n) time and without using the division
	 * 
	 * 
	 * Brute force :
	 * 1. approach would be to use two nested loops to calculate the product for each element, which would result in O(n^2) time complexity.
	 * 2. maintain two arrays, left and right, 
	 * where left[i] is the product of all elements to the left of index i 
	 * and right[i] is the product of all elements to the right of index i. 
	 * Then, we can calculate the answer for each index by multiplying left[i] and right[i]. 
	 * This approach would require O(n) time but also O(n) space.
	 * 
	 * Optimal approach :
	 * 1. We can optimize the space complexity to O(1) by using the answer array to store the left products 
	 * and a variable to keep track of the right product.
	 * 	
	 * 
	 */

	  public int[] productExceptSelf(int[] nums) {

		        int n = nums.length;
		        int[] answer = new int[n];

		        // store left products in answer
		        answer[0] = 1;
		        for (int i = 1; i < n; i++) {
		            answer[i] = answer[i - 1] * nums[i - 1];
		        }

		        // multiply right products using one variable
		        int rightProduct = 1;
		        for (int i = n - 1; i >= 0; i--) {
		            answer[i] = answer[i] * rightProduct;
		            rightProduct = rightProduct * nums[i];
		        }

		        return answer;
		    }

	  public static void main(String args[]) {
		  
		  ProductExceptSelf pes = new ProductExceptSelf();
		  int[] nums = {1,2,3,4};
		  System.out.print(Arrays.toString(pes.productExceptSelf(nums)));
		  
	  }
}
