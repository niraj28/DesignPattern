
public class DutchFlag {
	/* brute force sort: O(n log n)
	 * The Dutch National Flag problem is about sorting an array of only 3 distinct values in one pass.
	 * optimal: 3 pointers (low, mid, high)
	 * Time and space
		Time: O(n)
		Space: O(1)
	 */
	 public void sortColors(int[] nums) {
	        int low = 0, mid = 0, high = nums.length - 1;

	        while (mid <= high) {
	            if (nums[mid] == 0) {
	                swap(nums, low, mid);
	                low++;
	                mid++;
	            } else if (nums[mid] == 1) {
	                mid++;
	            } else { // nums[mid] == 2
	                swap(nums, mid, high);
	                high--;
	            }
	        }
	    }

	    private void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    
	    public static void main(String[] args) {
	        DutchFlag solution = new DutchFlag();
	        
	        int[] nums1 = {2, 0, 2, 1, 1, 0};
	        solution.sortColors(nums1);
	        System.out.print("Output: [");
	        for (int i = 0; i < nums1.length; i++) {
	            System.out.print(nums1[i]);
	            if (i < nums1.length - 1) System.out.print(", ");
	        }
	        System.out.println("]"); // Output: [0, 0, 1, 1, 2, 2]
	        
	        int[] nums2 = {2, 0, 1};
	        solution.sortColors(nums2);
	        System.out.print("Output: [");
	        for (int i = 0; i < nums2.length; i++) {
	            System.out.print(nums2[i]);
	            if (i < nums2.length - 1) System.out.print(", ");
	        }
	        System.out.println("]"); // Output: [0, 1, 2]
	    }
}
