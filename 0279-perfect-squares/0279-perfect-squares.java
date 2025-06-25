class Solution {

    private Integer[] memo;

    public int numSquares(int n) {
        int sq = (int)Math.sqrt(n);
        int[] sqs = new int[sq+1];
        for (int i=0; i<=sq; i++)
        {
            sqs[i] = i*i;
        }
        this.memo = new Integer[n+1];
        return helper(sqs, n);
    }

    private int helper(int[] sqs, int remain)
    {
        if (remain<0)
        {
            return 999999;
        }
        if (this.memo[remain]!=null)
        {
            return this.memo[remain];
        }
        if (remain==0)
        {
            return 0;
        }
        int min = 999999;
        for (int i=1; i<sqs.length; i++)
        {
            min = Math.min(min, helper(sqs, remain-sqs[i])+1);
        }
        this.memo[remain] = min;
        return min;
    }
}