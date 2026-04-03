public class ShipWithinDays {
	
    public static void main(String[] args) {

        // 👇 HARD CODE INPUT HERE
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;

        // Call function
        int result = 0;
		try {
			result = shipWithinDays(weights, days);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Print result
        System.out.println(result);
    }
    public static int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        long hi = 0;
        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }

        long left = lo, right = hi;
        while (left < right) {
            long mid = left + (right - left) / 2;
            try {
				try {
					if (canShip(weights, days, mid)) {
					    right = mid;      // try smaller
					} else {
					    left = mid + 1;   // need bigger
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return (int) left;
    }

    private static boolean canShip(int[] weights, int days, long cap) {
        int usedDays = 1;
        long curr = 0;

        for (int w : weights) {
            if (curr + w <= cap) {
                curr += w;
            } else {
                usedDays++;
                curr = w;
                if (usedDays > days) return false;
            }
        }
        return true;
    }
}