class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = (int)Math.pow(10, 9)+7;
        int[][][] dp = new int[n+1][m+1][k];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (i==0 && j==0)
                {
                    dp[1][1][grid[0][0]%k] = 1;
                }
                else
                {
                    for (int l=0; l<k; l++)
                    {
                        int pastIndex = (l+k-(grid[i][j]%k))%k;
                        dp[i+1][j+1][l] = dp[i][j+1][pastIndex]+dp[i+1][j][pastIndex];
                        dp[i+1][j+1][l] %= MOD;
                    }
                }
            }
        }
        return dp[n][m][0];
    }
}