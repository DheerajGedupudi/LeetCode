class Solution {

    private int MOD;
    private Integer[][][][] memo;

    public int numOfWays(int n) {
        this.MOD = (int)Math.pow(10, 9)+7;
        this.memo = new Integer[n][4][4][4];
        return helper(n, 0, 0, 0, 0);
    }

    private int helper(int n, int row, int prev1, int prev2, int prev3)
    {
        if (row==n)
        {
            return 1;
        }
        if (this.memo[row][prev1][prev2][prev3]!=null)
        {
            return this.memo[row][prev1][prev2][prev3];
        }
        long sum = 0;
        for (int col1=1; col1<=3; col1++)
        {
            if (col1==prev1) continue;
            for (int col2=1; col2<=3; col2++)
            {
                if (col2==prev2) continue;
                if (col1==col2) continue;
                for (int col3=1; col3<=3; col3++)
                {
                    if (col3==prev3) continue;
                    if (col2==col3) continue;
                    sum += helper(n, row+1, col1, col2, col3)%this.MOD;
                }
            }
        }
        this.memo[row][prev1][prev2][prev3] = (int)(sum%this.MOD);
        return this.memo[row][prev1][prev2][prev3];
    }
}