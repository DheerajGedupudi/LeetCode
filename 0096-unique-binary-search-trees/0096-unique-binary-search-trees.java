class Solution {
    private int[] memo;
    public int numTrees(int n) {
        this.memo = new int[n+1];
        Arrays.fill(this.memo, -1);
        return numWays(n);
    }

    private int numWays(int n)
    {
        if (this.memo[n]!=-1)
        {
            return this.memo[n];
        }
        if (n==0)
        {
            this.memo[n] = 1;
            return 1;
        }
        int ways = 0;
        for (int i=1; i<=n; i++)
        {
            int left = i-1;
            int right = n-i;
            // System.out.println("for :"+n+", ->> left : "+left+", right : "+right);
            ways += numWays(left)*numWays(right);
        }
        // System.out.println("ways of :"+n+", ->> "+ways);
        this.memo[n] = ways;
        return ways;
    }
}
