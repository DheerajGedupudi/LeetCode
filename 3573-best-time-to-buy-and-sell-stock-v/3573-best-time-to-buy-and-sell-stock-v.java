class Solution {

    private Long[][][] memo;

    public long maximumProfit(int[] prices, int k) {
        long max = 0;
        int n = prices.length;
        this.memo = new Long[n+1][k+1][3];
        return helper(prices, k, 0, 0);
    }

    private long helper(int[] prices, int k, int index, int state)
    {
        if (this.memo[index][k][state]!=null)
        {
            return this.memo[index][k][state];
        }
        int n = prices.length;
        if (index==n)
        {
            if (state==0)
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
        long max = helper(prices, k, index+1, state);
        // bought, can only sell
        if (state==1)
        {
            //sell
            //complete
            max = Math.max(max, helper(prices, k-1, index+1, 0)+prices[index]);
        }
        // sold already, can only buy
        else if (state==2)
        {
            //buy
            //complete
            max = Math.max(max, helper(prices, k-1, index+1, 0)-prices[index]);
        }
        //nothing, can buy or sell
        else if (state==0)
        {
            //buy
            max = Math.max(max, helper(prices, k, index+1, 1)-prices[index]);
            //sell
            max = Math.max(max, helper(prices, k, index+1, 2)+prices[index]);
        }
        // System.out.println("k : "+k+" -> index : "+index+", bought : "+bought+", sold : "+sold+", profit : "+max);
        this.memo[index][k][state] = max;
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