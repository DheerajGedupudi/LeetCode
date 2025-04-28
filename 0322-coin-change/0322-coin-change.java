class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = 999999999;
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for (int j=0; j<=amount; j++)
        {
            dp[0][j] = INF;
        }
        for (int i=0; i<=n; i++)
        {
            dp[i][0] = 0;
        }
        for (int i=1; i<=n; i++)
        {
            int coin = coins[i-1];
            for (int j=1; j<coin && j<=amount; j++)
            {
                dp[i][j] = dp[i-1][j];
            }
            for (int j=coin; j<=amount; j++)
            {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-coin]+1);
            }
            // print(dp);
        }
        if (dp[n][amount]==INF)
        {
            return -1;
        }
        return dp[n][amount];
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            for (int c  :row)
            {
                if (c==Integer.MAX_VALUE)
                {
                    System.out.print("INF, ");
                }
                else
                {
                    System.out.print(c+", ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}



/*

coins
[1,2,5]

amount

1 -> 11


. . 1 2 3 4 5 6 7 8 9 10 11
-----------------------------
1 0 1 2 3 4 5 6 7 8 9 10 11
2 0 1 1 2 2 3 3 4 4 5 5  6
5 0 1 1 2 2 1 2 2 

*/