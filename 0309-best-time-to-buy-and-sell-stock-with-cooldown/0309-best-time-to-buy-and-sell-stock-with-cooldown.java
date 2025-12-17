class Solution {

    private Integer[][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new Integer[n][2];
        return helper(prices, 0, 0);
    }

    private int helper(int[] prices, int index, int bought)
    {
        int n = prices.length;
        if (index>=n)
        {
            return 0;
        }
        if (this.memo[index][bought]!=null)
        {
            return this.memo[index][bought];
        }
        //nothing
        int max = helper(prices, index+1, bought);
        //bought, can sell
        if (bought==1)
        {
            max = Math.max(max, helper(prices, index+2, 0)+prices[index]);
        }
        //not bought, can buy
        else
        {
            max = Math.max(max, helper(prices, index+1, 1)-prices[index]);
        }
        this.memo[index][bought] = max;
        return max;
    }
}