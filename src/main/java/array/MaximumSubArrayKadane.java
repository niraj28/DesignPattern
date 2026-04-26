package array;

public class MaximumSubArrayKadane {
	/*
	 * Brute Force Approach:
	 * 1. We can use two nested loops to generate all possible subarrays of the
	 * input array.
	 * 2. For each subarray, we calculate the sum of its elements and keep
	 * track of the maximum sum found so far.
	 * 3. Finally, we return the maximum sum.
	 * Time Complexity: O(n^2) - We have two nested loops to generate sub
	 * arrays and calculate their sums.
	 * 	Space Complexity: O(1) - We are using a constant amount of space to store the maximum sum.
	 * 
	 * Optimized Approach (Kadane's Algorithm):
	 * 1. We can use a single pass through the array to calculate the maximum sum
	 * 2. We maintain two variables, currentSum and maxSum, to keep track
	 * 	of the current sum of the subarray and the maximum sum found so far.
	 * 3. We iterate through the array, and for each element, we update current
	 * sum by taking the maximum of the current element and the sum of currentSum
	 * and the current element. This step ensures that we are always considering
	 * the maximum sum of a subarray that ends at the current index.
	 * 4. We also update maxSum by taking the maximum of maxSum and current
	 * 	sum at each step to keep track of the maximum sum found so far.
	 * 	5. Finally, we return maxSum as the result.
	 * 
	 * Time Complexity: O(n) - We traverse the array once.
	 * Space Complexity: O(1) - We are using a constant amount of space to
	 *
	 *
	 */
    public int maxSubArray(int[] nums) {
    	 
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
    
    public static void main(String args[] ){
    	
    	MaximumSubArrayKadane maxSubKadane = new MaximumSubArrayKadane();
    	
    	int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    	
    	System.out.print(maxSubKadane.maxSubArray(nums));
    	
    }
}
