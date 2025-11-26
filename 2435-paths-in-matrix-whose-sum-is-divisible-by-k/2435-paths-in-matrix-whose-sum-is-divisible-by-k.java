class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int MOD = (int)Math.pow(10, 9)+7;
        int[][][] dp = new int[n+1][m+1][k];
        int[][] currRow = new int[m+1][k];
        int[][] prevRow = new int[m+1][k];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (i==0 && j==0)
                {
                    currRow[1][grid[0][0]%k] = 1;
                }
                else
                {
                    for (int l=0; l<k; l++)
                    {
                        int pastIndex = (l+k-(grid[i][j]%k))%k;
                        currRow[j+1][l] = prevRow[j+1][pastIndex]+currRow[j][pastIndex];
                        currRow[j+1][l] %= MOD;
                    }
                }
            }
            prevRow = currRow;
            currRow = new int[m+1][k];
        }
        return prevRow[m][0];
    }
}