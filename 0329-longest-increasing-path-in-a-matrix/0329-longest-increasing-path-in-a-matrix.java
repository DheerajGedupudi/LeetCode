class Solution {

    private int[][] dirs;
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        this.dirs = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        int max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        this.memo = new int[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int k = dfs(matrix, i, j);
                // System.out.println(i+", "+j+" => "+k);
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int x, int y)
    {
        if (this.memo[x][y]!=0)
        {
            return this.memo[x][y];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        for (int[] dir : dirs)
        {
            int nx = x+dir[0];
            int ny = y+dir[1];
            if (nx>=0 && nx<n && ny>=0 && ny<m && matrix[nx][ny]<matrix[x][y])
            {
                max = Math.max(max, dfs(matrix, nx, ny));
            }
        }
        this.memo[x][y] = max+1;
        return max+1;
    }
}