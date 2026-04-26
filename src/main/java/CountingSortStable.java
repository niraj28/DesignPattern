
public class CountingSortStable {
	/* counting sort (stable): O(n + k), where n is the number of elements in the input array and k is the range of the input values.
	 * Time: O(n + k)
	 * Space: O(k)
	 */
	
	public int[] countingSortStable(int[] nums) {
	    int max = 0;
	    for (int num : nums) {
	        max = Math.max(max, num);
	    }

	    int[] count = new int[max + 1];

	    // frequency
	    for (int num : nums) {
	        count[num]++;
	    }

	    // prefix sum
	    for (int i = 1; i < count.length; i++) {
	        count[i] += count[i - 1];
	    }

	    int[] output = new int[nums.length];

	    // build output (right to left)
	    for (int i = nums.length - 1; i >= 0; i--) {
	        output[count[nums[i]] - 1] = nums[i];
	        count[nums[i]]--;
	    }

	    return output;
	}
	public static void main(String[] args) {
		CountingSortStable solution = new CountingSortStable();
		
		int[] nums1 = {4, 2, 2, 8, 3, 3, 1};
		int[] result1 = solution.countingSortStable(nums1);
		System.out.print("Output: [");
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i]);
			if (i < result1.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1, 2, 2, 3, 3, 4, 8]
		
		int[] nums2 = {5, 4, 3, 2, 1};
		int[] result2 = solution.countingSortStable(nums2);
		System.out.print("Output: [");
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i]);
			if (i < result2.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1, 2, 3, 4, 5]
	}
}
