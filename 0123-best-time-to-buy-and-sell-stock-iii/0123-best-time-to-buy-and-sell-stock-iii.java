class Solution {

    private Integer[][][] memo;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        this.memo = new Integer[n+1][2][3];
        return helper(prices, 0, 0, 2);
    }
    
    private int helper(int[] prices, int index, int bought, int k)
    {
        if (this.memo[index][bought][k]!=null)
        {
            return this.memo[index][bought][k];
        }
        int n = prices.length;
        if (index==n)
        {
            if (bought==0)
            {
                return 0;
            }
            else
            {
                return (int)-Math.pow(10, 9);
            }
        }
        if (k==0)
        {
            return 0;
        }
        //nothing
        int max = helper(prices, index+1, bought, k);
        //bought, can sell
        if (bought==1)
        {
            max = Math.max(max, helper(prices, index+1, 0, k-1)+prices[index]);
        }
        //not bought, can buy
        else
        {
            max = Math.max(max, helper(prices, index+1, 1, k)-prices[index]);
        }
        this.memo[index][bought][k] = max;
        return max;
    }
}