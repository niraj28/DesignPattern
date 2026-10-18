package interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval {
	
	public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged list is empty or no overlap, add directly
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap -> merge by updating end
                merged.get(merged.size() - 1)[1] =
                        Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
	
	public static void main(String[] args) {
		MergeInterval mi = new MergeInterval();
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = mi.merge(intervals);
		for (int[] interval : result) {
			System.out.println(Arrays.toString(interval));
		}
	}

}
