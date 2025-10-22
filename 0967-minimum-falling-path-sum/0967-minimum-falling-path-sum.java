class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] row = Arrays.copyOf(matrix[0], m);
        for (int i=1; i<n; i++)
        {
            int[] dp = Arrays.copyOf(row, m);
            dp[0] = Math.min(row[0], row[1]) + matrix[i][0];
            for (int j=1; j<m-1; j++)
            {
                int max = Math.min(Math.min(row[j-1], row[j]), row[j+1]);
                dp[j] = max+matrix[i][j];
            }
            dp[m-1] = Math.min(row[m-2], row[m-1]) + matrix[i][m-1];
            row = dp;
        }
        int min = Integer.MAX_VALUE;
        for (int x : row)
        {
            min = Math.min(min, x);
        }
        return min;
    }
}