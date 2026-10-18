package walmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	/*
	 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]

/*
	 * Brute force:
	 * 1. Count frequency using HashMap
	 * 2. Sort entries by frequency
	 * 3. Pick top k
	 *
	 * Time: O(n + m log m)
	 * Space: O(m)
	 *
	 * Optimal:
	 * 1. Count frequency using HashMap
	 * 2. Use bucket sort where index = frequency
	 * 3. Traverse bucket from end to start
	 *
	 * Time: O(n)
	 * Space: O(n)
	 */
    
	
	
	public int[] topKFrequent(int[] nums, int k) {
	      /* 

	      */
		
		// count frequency
		Map<Integer, Integer> mapFreq = new HashMap<>();
		
		for(int num : nums) {
			mapFreq.put(num, mapFreq.getOrDefault(num,0) +1);
		}
		
		// create the bucket and put the values of freq at the freq as bucket index with values
		
		List<Integer>[] buckets = new ArrayList[nums.length+1];
		
		
		for(int key : mapFreq.keySet()) {
			int freq = mapFreq.get(key);
			if(buckets[freq] == null) {
				buckets[freq] = new ArrayList<>();
			}
			buckets[freq].add(key);
		}
		
		// return top k in the result 
		
		int[] result = new int[k];
		int index=0;
		
		for(int i = buckets.length-1; i>=0 && index<k ; i--) {
			if(buckets[i]!=null) {
				for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
			}
		}
		
		
		

	        return result; 
	    }
	public static void main(String[] args) {
		TopKFrequentElements obj = new TopKFrequentElements();
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		int[] result = obj.topKFrequent(nums, k);
		for(int num : result) {
			System.out.print(num + " ");
		}
	}

}
