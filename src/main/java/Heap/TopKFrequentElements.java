package Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	
	/* Approach:  HashMap + bucket sort.
	 * 1. Use a HashMap to count the frequency of each element in the input array.
	 * 2. Create an array of lists (buckets) where the index represents the frequency. 
	 * Each bucket will contain the elements that have that frequency.
	 * 3. Iterate through the buckets from the highest frequency to the lowest, collecting elements
	 * 	until we have collected k elements.
	 * 	Complexity
	 * 	Time: O(n) for counting frequencies + O(n) for filling buckets + O(n) for collecting top k elements = O(n)
	 * 	Space: O(n) for the frequency map and buckets
	 * 		
	 * Bucket Sort: Put element in position = its frequency					
	 */
	
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: frequency count
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: buckets, index = frequency
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        // Step 3: collect top k from high freq to low
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) break;
                }
            }
        }

        return result; 
    }
    
    public static void main(String[] args) {
		TopKFrequentElements solution = new TopKFrequentElements();
		
		int[] nums1 = {1,1,1,2,2,3};
		int k1 = 2;
		int[] result1 = solution.topKFrequent(nums1, k1);
		System.out.print("Output: [");
		for (int i = 0; i < result1.length; i++) {
			System.out.print(result1[i]);
			if (i < result1.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1, 2]
		
		int[] nums2 = {1};
		int k2 = 1;
		int[] result2 = solution.topKFrequent(nums2, k2);
		System.out.print("Output: [");
		for (int i = 0; i < result2.length; i++) {
			System.out.print(result2[i]);
			if (i < result2.length - 1) System.out.print(", ");
		}
		System.out.println("]"); // Output: [1]
		
	}

}
