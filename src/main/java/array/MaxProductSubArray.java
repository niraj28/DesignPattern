package array;

public class MaxProductSubArray {
	/*
	 * Brute Force Approach:
	 * 1. We can use two nested loops to generate all possible subarrays of the input array.
	 * 2. For each subarray, we calculate the product of its elements and keep
	 * track of the maximum product found so far.
	 * 3. Finally, we return the maximum product.
	 * Time Complexity: O(n^2) - We have two nested loops to generate subarrays and calculate their products.
	 * 	Space Complexity: O(1) - We are using a constant amount of space to store the maximum product.
	 * 
	 * Optimized Approach:
	 * 1. We can use a single pass through the array to calculate the maximum product
	 *  2. We maintain two variables, maxSoFar and minSoFar, to keep track of the maximum and minimum products at each step.
	 * 3. We iterate through the array, and for each element, 
	 * we update maxSoFar and minSoFar based on the current element and the previous values of maxSoFar and minSoFar.
	 * 4. If the current element is negative, we swap maxSoFar and minSoFar because multiplying by a negative number will flip the signs.
	 * 5. We also keep track of the maximum product found so far and return it.
	 * Time Complexity: O(n) - We traverse the array once.
	 * Space Complexity: O(1) - We are using a constant amount of space to store the maximum and minimum products.	
	 * 
	 *  
	 */
	
	public int maxProduct(int[] nums) {

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // If negative → swap
            if (nums[i] < 0) {
                int temp = maxSoFar;
                maxSoFar = minSoFar;
                minSoFar = temp;
            }

            maxSoFar = Math.max(nums[i], maxSoFar * nums[i]);
            minSoFar = Math.min(nums[i], minSoFar * nums[i]);

            result = Math.max(result, maxSoFar);
        }

        return result;
    }
	
	public static void main(String args[]) {
		
		MaxProductSubArray product = new MaxProductSubArray();
		int[] nums = {2,3,-2,4};
		
		System.out.println(product.maxProduct(nums));
		
	}

}
