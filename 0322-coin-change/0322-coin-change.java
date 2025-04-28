class Solution {
    public int coinChange(int[] coins, int amount) {
        int INF = 999999999;
        Arrays.sort(coins);
        int n = coins.length;
        int[] prevRow = new int[amount+1];
        for (int j=0; j<=amount; j++)
        {
            prevRow[j] = INF;
        }
        prevRow[0] = 0;
        for (int i=1; i<=n; i++)
        {
            int coin = coins[i-1];
            int[] currRow = Arrays.copyOf(prevRow, amount+1);
            for (int j=coin; j<=amount; j++)
            {
                currRow[j] = Math.min(currRow[j], currRow[j-coin]+1);
            }
            prevRow = currRow;
        }
        if (prevRow[amount]==INF)
        {
            return -1;
        }
        return prevRow[amount];
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