class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] grid = new int[n][n];
        for (int[] q : queries)
        {
            for (int i=q[0]; i<=q[2]; i++)
            {
                grid[i][q[1]]++;
                if (q[3]+1<n)
                {
                    grid[i][q[3]+1]--;
                }
            }
        }
        for (int[] row : grid)
        {
            int sum = 0;
            for (int i=0; i<n; i++)
            {
                sum += row[i];
                row[i] = sum;
            }
        }
        return grid;
    }
}