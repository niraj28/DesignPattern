package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	  public int[] twoSum(int[] nums, int target) {
		  
		  /*
		   * brute force : for each num check on remaining each if the sum gets to target
		   *  time: O(n*(n-1))
		   *  space: O(1)
		   *  
		   *  Optimal: 
		   *  maintain a map of nums , and see if the complement of num present in the map being created
		   *  
		   *  time:O(n)
		   *  space: O(n)
		   *  
		   */
		  Map<Integer, Integer> map = new HashMap<>();
		  
		  for(int i=0; i<nums.length; i++) {
			  int compl = target - nums[i];
			  
			  if(map.containsKey(compl)) {
				  
				  return new int[] {map.get(compl), i};
				  
			  }else {
				  map.put(nums[i], i);
			  }
			  
			  
		  }
		  return new int[] {};
		  
	  }
	  
	  public static void main(String[] args) {
		  TwoSum solution = new TwoSum();
		  
		  int[] nums1 = {2,7,11,15};
		  int target1 = 9;
		  int[] result1 = solution.twoSum(nums1, target1);
		  System.out.print("Output: [");
		  for (int i = 0; i < result1.length; i++) {
			  System.out.print(result1[i]);
			  if (i < result1.length - 1) System.out.print(", ");
		  }
		  System.out.println("]"); // Output: [0, 1]
		  
		  int[] nums2 = {3,2,4};
		  int target2 = 6;
		  int[] result2 = solution.twoSum(nums2, target2);
		  System.out.print("Output: [");
		  for (int i = 0; i < result2.length; i++) {
			  System.out.print(result2[i]);
			  if (i < result2.length - 1) System.out.print(", ");
		  }
		  System.out.println("]"); // Output: [1, 2]
		  
		  int[] nums3 = {3,3};
		  int target3 = 6;
		  int[] result3 = solution.twoSum(nums3, target3);
		  System.out.print("Output: [");
		  for (int i = 0; i < result3.length; i++) {
			  System.out.print(result3[i]);
			  if (i < result3.length - 1) System.out.print(", ");
		  }
		  System.out.println("]"); // Output: [0, 1]
	  }
	  

}
