package array;

public class MaxProfit {
	
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
