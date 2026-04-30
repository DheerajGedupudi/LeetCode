class Solution {
    private int negINF;
    private int[][][] memo;

    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int budget = Math.min(k, n+m);
        this.memo = new int[n][m][budget+1];
        for (int[][] a : this.memo)
        {
            for (int[] b : a)
            {
                Arrays.fill(b, Integer.MIN_VALUE);
            }
        }
        this.negINF = -1*(int)Math.pow(10,7);
        int result = helper(grid, 0, 0, budget);
        if (result<0)
        {
            return -1;
        }
        return result;
    }

    private int helper(int[][] grid, int x, int y, int k)
    {
        int n = grid.length;
        int m = grid[0].length;
        if (x>=n || y>=m)
        {
            return this.negINF;
        }
        if (this.memo[x][y][k]!=Integer.MIN_VALUE)
        {
            return this.memo[x][y][k];
        }
        int cost = 0;
        int score = 0;
        if (grid[x][y]>0)
        {
            cost++;
            score += grid[x][y];
        }
        if (cost > k)
        {
            return this.negINF;
        }
        if (x==n-1 && y==m-1)
        {
            return score;
        }
        this.memo[x][y][k] = score + Math.max(helper(grid, x+1, y, k-cost), helper(grid, x, y+1, k-cost));
        return this.memo[x][y][k];
    }
}