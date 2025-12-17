class Solution {

    private Long[][][][] memo;

    public long maximumProfit(int[] prices, int k) {
        long max = 0;
        int n = prices.length;
        this.memo = new Long[n+1][k+1][2][2];
        return helper(prices, k, 0, 0, 0);
    }

    private long helper(int[] prices, int k, int index, int sold, int bought)
    {
        if (this.memo[index][k][sold][bought]!=null)
        {
            return this.memo[index][k][sold][bought];
        }
        int n = prices.length;
        if (index==n)
        {
            if (sold==0 && bought==0)
            {
                return 0;
            }
            else
            {
                return (long)-Math.pow(10, 18);
            }
        }
        if (k==0)
        {
            return 0;
        }
        //nothing
        long max = helper(prices, k, index+1, sold, bought);
        // bought, can only sell
        if (bought==1)
        {
            //sell
            //complete
            max = Math.max(max, helper(prices, k-1, index+1, 0, 0)+prices[index]);
        }
        // sold already, can only buy
        else if (sold==1)
        {
            //buy
            //complete
            max = Math.max(max, helper(prices, k-1, index+1, 0, 0)-prices[index]);
        }
        //nothing, can buy or sell
        else if (bought==0 && sold==0)
        {
            //buy
            max = Math.max(max, helper(prices, k, index+1, 0, 1)-prices[index]);
            //sell
            max = Math.max(max, helper(prices, k, index+1, 1, 0)+prices[index]);
        }
        // System.out.println("k : "+k+" -> index : "+index+", bought : "+bought+", sold : "+sold+", profit : "+max);
        this.memo[index][k][sold][bought] = max;
        return max;

    }
}


/*


[]
buy->sell
sell->buy
keep stock
ignore stock

*/