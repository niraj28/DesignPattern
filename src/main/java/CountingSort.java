
public class CountingSort {
	/* counting sort: O(n + k), where n is the number of elements in the input array and k is the range of the input values.
	 * Time: O(n + k)
	 * Space: O(k)
	 */
	public void countingSort(int[] nums) {
	    int maxValue = 0;
	    for (int num : nums) {
	        maxValue = Math.max(maxValue, num);
	    }

	    int[] count = new int[maxValue + 1];

	    for (int num : nums) {
	        count[num]++;
	    }

	    int writeIndex = 0;
	    for (int value = 0; value < count.length; value++) {
	        for (int i = 0; i < count[value]; i++) {
	            nums[writeIndex++] = value;
	        }
	    }
	}
	
	public static void main(String[] args) {
		CountingSort solution = new CountingSort();
		
		int[] nums1 = {4, 2, 2, 8, 3, 3, 1};
		solution.countingSort(nums1);
		System.out.print("Output: [");
		for (int i = 0; i < nums1.length; i++) {
			System.out.print(nums1[i]);
			if (i < nums1.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1, 2, 2, 3, 3, 4, 8]
		
		int[] nums2 = {5, 4, 3, 2, 1};
		solution.countingSort(nums2);
		System.out.print("Output: [");
		for (int i = 0; i < nums2.length; i++) {
			System.out.print(nums2[i]);
			if (i < nums2.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1, 2, 3, 4, 5]
		
	}
}
