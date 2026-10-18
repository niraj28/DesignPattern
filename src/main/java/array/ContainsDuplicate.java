package array;

import java.util.HashSet;

public class ContainsDuplicate {
	  public static boolean containsDuplicate(int[] nums) {
	        HashSet<Integer> set = new HashSet<>();

	        for (int num : nums) {
	            if (set.contains(num)) {
	                return true;
	            }
	            set.add(num);
	        }

	        return false;
	    }
	  public static void main(String args[]) {
		  
		  ContainsDuplicate cd =  new ContainsDuplicate();
		  int[]  nums = {1,2,3,1};
 		  System.out.print(containsDuplicate(nums));
		  
	  }
}
