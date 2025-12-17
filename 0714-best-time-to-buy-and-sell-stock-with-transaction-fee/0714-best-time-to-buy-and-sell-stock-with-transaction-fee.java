class Solution {

    private Integer[][] memo;

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        this.memo = new Integer[n+1][2];
        return helper(prices, fee, 0, 0);
    }

    private int helper(int[] prices, int fee, int index, int bought)
    {
        if (this.memo[index][bought]!=null)
        {
            return this.memo[index][bought];
        }
        int n = prices.length;
        if (index==n)
        {
            return 0;
        }
        //nothing
        int max = helper(prices, fee, index+1, bought);
        //bought, can sell
        if (bought==1)
        {
            max = Math.max(max, helper(prices, fee, index+1, 0)+prices[index]-fee);
        }
        //not bought, can buy
        else
        {
            max = Math.max(max, helper(prices, fee, index+1, 1)-prices[index]);
        }
        this.memo[index][bought] = max;
        return max;
    }
}