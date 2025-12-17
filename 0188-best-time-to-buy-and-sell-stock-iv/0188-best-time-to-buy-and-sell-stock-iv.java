class Solution {

    private Integer[][][] memo;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        this.memo = new Integer[n+1][k+1][2];
        return helper(k, prices, 0, 0);
    }

    private int helper(int k, int[] prices, int index, int bought)
    {
        if (this.memo[index][k][bought]!=null)
        {
            return this.memo[index][k][bought];
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
        int max = helper(k, prices, index+1, bought);
        if (bought==1)
        {
            //sell
            max = Math.max(max, helper(k-1, prices, index+1, 0)+prices[index]);
        }
        else
        {
            //buy
            max = Math.max(max, helper(k, prices, index+1, 1)-prices[index]);
        }
        this.memo[index][k][bought] = max;
        return max;
    }
}