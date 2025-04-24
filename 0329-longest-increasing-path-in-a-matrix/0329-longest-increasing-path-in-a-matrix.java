class Solution {

    private int[][] dp;
    private int[][] dirs;
    private boolean[][] globalVisited;
    private int max;

    public int longestIncreasingPath(int[][] matrix) {
        this.dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0} };
        this.max = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        this.globalVisited = new boolean[n][m];
        this.dp = new int[n][m]; 
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                this.dp[i][j] = 1;
            }
        }
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                // System.out.println("started at "+i+", "+j+" -=-=-=-=-=-=-=-=-=-=-==-------------------------");
                boolean[][] visited = new boolean[n][m];
                visited[i][j] = true;
                globalVisited[i][j] = true;
                dfs(matrix, i, j, visited);
                visited[i][j] = false;
                // print(dp);
            }
        }
        return this.max;
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] visited)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int[] dir : dirs)
        {
            int r = dir[0]+x;
            int c = dir[1]+y;
            if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && matrix[r][c]>matrix[x][y])
            {
                // System.out.println("Next checking : "+r+", "+c+" number at  : "+matrix[r][c]);
                // print(this.dp);
                if (this.globalVisited[r][c]==false)
                {
                    //explore
                    visited[r][c] = true;
                    dfs(matrix, r, c, visited);
                    visited[r][c] = false;
                }
                this.dp[x][y] = Math.max(this.dp[x][y], this.dp[r][c]+1);
                this.globalVisited[x][y] = true;
            }
            this.max = Math.max(this.max, this.dp[x][y]);
        }
    }
}