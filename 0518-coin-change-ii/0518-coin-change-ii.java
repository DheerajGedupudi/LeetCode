class Solution {

    private int[][] memo;

    public int change(int amount, int[] coins) {
        this.memo = new int[coins.length][amount+1];
        for (int i=0; i<coins.length; i++)
        {
            Arrays.fill(this.memo[i], -1);
        }
        return helper(coins, amount, amount, coins.length-1);
    }

    private int helper(int[] coins, int amount, int remain, int index)
    {
        if (remain<0)
        {
            return 0;
        }
        if (this.memo[index][remain]!=-1)
        {
            return this.memo[index][remain];
        }
        if (remain==0)
        {
            return 1;
        }
        for (int i=index; i<coins.length; i++)
        {
            this.memo[i][remain] = helper(coins, amount, remain-coins[i], i) + (i>0?(helper(coins, amount, remain, i-1)):0);
        }
        // print();
        return this.memo[index][remain];
    }

    private void print()
    {
        for (int i=0; i<this.memo.length; i++)
        {
            System.out.println(Arrays.toString(this.memo[i]));
        }
        System.out.println();
    }
}