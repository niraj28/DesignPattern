package array;

import java.util.Arrays;

public class ProductExceptSelf {

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
