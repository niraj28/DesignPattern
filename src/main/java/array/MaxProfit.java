package array;

public class MaxProfit {
	/*
	 * 
	 *Brute Force Approach: We can use two nested loops to check every possible pair of buy and sell days. 
	 *The outer loop will iterate through the prices array, and the inner loop will check for all subsequent days to calculate the profit. 
	 *This approach has a time complexity of O(n^2).
	 *
	 * Optimal Approach: We can keep track of the minimum price seen so far and calculate the profit at each step.
	 */
	
	public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
      int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i]; // buy here
            } else {
                int profit = prices[i] - minPrice; // sell here
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
    public static void main(String args[]){
    	MaxProfit sol= new MaxProfit();
        int[] pricess = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(pricess));
    }

}
