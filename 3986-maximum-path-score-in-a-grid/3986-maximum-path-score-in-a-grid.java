class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n+1][m+1][k+1];
        for (int i=2; i<=n; i++)
        {
            Arrays.fill(dp[i][0], Integer.MIN_VALUE);
        }
        for (int j=2; j<=m; j++)
        {
            Arrays.fill(dp[0][j], Integer.MIN_VALUE);   
        }
        // print(dp);
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                Arrays.fill(dp[i+1][j+1], Integer.MIN_VALUE);
                for (int l=0; l<=k; l++)
                {
                    int fromLeft = dp[i+1][j][l];
                    int fromTop = dp[i][j+1][l];
                    int kIndex = l;
                    if (grid[i][j]>0)
                    {
                        kIndex++;
                    }
                    if (kIndex<=k)
                    {
                        dp[i+1][j+1][kIndex] = Math.max(dp[i+1][j+1][kIndex], Math.max(fromLeft, fromTop));
                        if (dp[i+1][j+1][kIndex]>=0)
                        {
                            dp[i+1][j+1][kIndex] += grid[i][j];
                        }
                    }
                }
            }
        }
        // print(dp);
        int max = Integer.MIN_VALUE;
        for (int l=0; l<=k; l++)
        {
            max = Math.max(max, dp[n][m][l]);
        }
        // System.out.println("result : -----"+Arrays.toString(dp[n][m]));
        if (max<0)
        {
            return -1;
        }
        return max;
    }

    private void print(int[][][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int max = Integer.MIN_VALUE;
                for (int x : grid[i][j])
                {
                    max = Math.max(max, x);
                }
                System.out.print(max+", ");
                // System.out.println(i+", "+j+" ->>>>>>>>>>>> "+Arrays.toString(grid[i][j]));
            }
            System.out.println();
        }
    }
}




/*

[],[],[]
[],-in, 
[]


[0,2,2]
[1,1,1]
[0,0,2]



*/