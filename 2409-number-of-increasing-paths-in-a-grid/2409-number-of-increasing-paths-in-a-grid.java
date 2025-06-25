class Solution {

    private static final int MOD = (int)Math.pow(10,9)+7;
    private int[][] dirs;
    private int[][] memo;

    public int countPaths(int[][] grid) {
        this.dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int sum = 0;
        int n = grid.length;
        int m = grid[0].length;
        this.memo = new int[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                sum += dfs(grid, i, j);
                sum %= MOD;
            }
        }
        return sum;
    }

    private int dfs(int[][] grid, int x, int y)
    {
        if (this.memo[x][y]!=0)
        {
            return this.memo[x][y];
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int[] dir : dirs)
        {
            int nx = x+dir[0];
            int ny = y+dir[1];
            if (nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]<grid[x][y])
            {
                count += dfs(grid, nx, ny);
            }
        }
        count++;
        count %= MOD;
        this.memo[x][y] = count;
        return count;
    }
}