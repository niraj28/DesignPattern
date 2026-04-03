package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSumProblem {
	
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        int n =nums.length;
       for (int i = 0; i < n - 3; i++) {
            // Skip duplicate first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate second element
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // Skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
    
    // 🔹 Main method to run
    public static void main(String[] args) {
    	FourSumProblem sol = new FourSumProblem();

        int[] nums = {1,0,-1,0,-2,2};  // ✅ your input

        List<List<Integer>> result = sol.fourSum(nums, 0);

        System.out.println(result);
    }

}
