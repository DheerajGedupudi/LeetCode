class Solution {

    private long[][][] memo;
    private long[][] prefix;

    public long maximumScore(int[][] grid) {
        int n = grid.length;
        long[][][] dp = new long[n+2][n+1][n+1];
        this.prefix = getPrefix(grid);
        for (int prev = 0; prev <= n; prev++) {
            for (int prevprev = 0; prevprev <= n; prevprev++) {
                long score = (n - 1 >= 0)
                    ? Math.max(0, prefix[prevprev][n-1] - prefix[prev][n-1])
                    : 0;
                dp[n][prev][prevprev] = score;
            }
        }
        for (int c=n-1; c>=0; c--)
        {
            long[][] prefMax = new long[n+1][n+2];
            long[][] suffMax = new long[n+1][n+2];
            for (int prev=0; prev<=n; prev++)
            {
                prefMax[prev][0] = dp[c+1][0][prev];
                for (int j = 1; j <= n; j++)
                {
                    prefMax[prev][j] = Math.max(prefMax[prev][j-1], dp[c+1][j][prev]);
                }
                suffMax[prev][n+1] = Long.MIN_VALUE;       // sentinel: empty range
                for (int j = n; j >= 0; j--) {
                    long score_j = (c - 1 >= 0)
                        ? Math.max(0, prefix[j][c-1] - prefix[prev][c-1])
                        : 0;
                    long g = dp[c+1][j][prev] + score_j;
                    suffMax[prev][j] = Math.max(suffMax[prev][j+1], g);
                }

                for (int prevprev=0; prevprev<=n; prevprev++)
                {
                    long S_const = (c - 1 >= 0)
                        ? Math.max(0, prefix[prevprev][c-1] - prefix[prev][c-1])
                        : 0;
                    long M_a = prefMax[prev][prevprev] + S_const;
                    long M_b = suffMax[prev][prevprev + 1];   // safe because we sized suffMaxG to n+2
                    dp[c][prev][prevprev] = Math.max(M_a, M_b);
                }
            }

        }
        return dp[0][0][0];
    }

    private long[][] getPrefix(int[][] grid)
    {
        int n = grid.length;
        long[][] prefix = new long[n+1][n];
        for (int col=0; col<n; col++)
        {
            for (int row=0; row<n; row++)
            {
                prefix[row+1][col] = prefix[row][col] + grid[row][col];
            }
        }
        return prefix;
    }
}