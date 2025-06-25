class Solution {

    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        this.memo = new Integer[amount+1];
        int ans = helper(coins, amount);
        if (ans==999999999)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }

    private int helper(int[] coins, int remain)
    {
        if (this.memo[remain]!=null)
        {
            return this.memo[remain];
        }
        if (remain==0)
        {
            return 0;
        }
        int min = 999999999;
        for (int i=0; i<coins.length; i++)
        {
            if (remain-coins[i]>=0)
            {
                min = Math.min(min, helper(coins, remain-coins[i])+1);
            }
        }
        this.memo[remain] = min;
        return min;
    }
}