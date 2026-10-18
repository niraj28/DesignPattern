package interval;

import java.util.Arrays;

public class NonOverlappingIntervals {
	
	public int eraseOverlapIntervals(int[][] intervals) {
        // Sort by end time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int countKept = 1;   // first interval is kept
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval does not overlap
            if (intervals[i][0] >= prevEnd) {
                countKept++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - countKept;
    }  
	
	public static void main(String[] args) {
		NonOverlappingIntervals solution = new NonOverlappingIntervals();
		
		int[][] intervals1 = {{1,2}, {2,3}, {3,4}, {1,3}};
		System.out.println(solution.eraseOverlapIntervals(intervals1)); // Output: 1
		
		int[][] intervals2 = {{1,2}, {1,2}, {1,2}};
		System.out.println(solution.eraseOverlapIntervals(intervals2)); // Output: 2
		
		int[][] intervals3 = {{1,2}, {2,3}};
		System.out.println(solution.eraseOverlapIntervals(intervals3)); // Output: 0
	}
}
