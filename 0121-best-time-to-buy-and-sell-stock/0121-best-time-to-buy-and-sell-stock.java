class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] mins = new int[n];
        int[] maxs = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
        {
            min = Math.min(min, prices[i]);
            mins[i] = min;
        }
        for (int i=n-1; i>=0; i--)
        {
            max = Math.max(max, prices[i]);
            maxs[i] = max;
        }
        int maxProfit = 0;
        for (int i=0; i<n; i++)
        {
            int profit = maxs[i]-mins[i];
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}