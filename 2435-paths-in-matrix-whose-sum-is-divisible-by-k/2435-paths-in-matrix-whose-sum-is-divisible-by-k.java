class Solution {

    private int MOD;
    private int[][][] memo;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        this.memo = new int[n][m][k];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                this.memo[i][j][0] = -1;
            }
        }
        this.MOD = (int)Math.pow(10, 9)+7;
        int[] result = helper(grid, k, n-1, m-1);
        return result[0];
    }

    //int[] = {0,1,2,...,k-1}
    // ways to arrive at this sum % k

    private int[] helper(int[][] grid, int k, int x, int y)
    {
        int n = grid.length;
        int m = grid[0].length;
        if (x<0 || y<0)
        {
            return new int[k];
        }
        if (this.memo[x][y][0]!=-1)
        {
            return this.memo[x][y];
        }
        if (x==0 && y==0)
        {
            int[] arr = new int[k];
            arr[grid[0][0]%k] = 1;
            return arr;
        }
        //from top
        int[] top = helper(grid, k, x-1, y);
        //from left
        int[] left = helper(grid, k, x, y-1);
        int[] ways = new int[k]; 
        for (int i=0; i<k; i++)
        {
            int pastIndex = (i+k-(grid[x][y])%k)%k;
            //from left
            if (y-1>=0)
            {
                ways[i] += left[pastIndex];
                ways[i] %= this.MOD;
            }
            //from top
            if (x-1>=0)
            {
                ways[i] += top[pastIndex];
                ways[i] %= this.MOD;
            }
        }
        this.memo[x][y] = ways;
        return ways;
    }
}