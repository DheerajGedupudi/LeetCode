class Solution {

    private int[][] dp;
    private int[][] dirs;

    public int longestIncreasingPath(int[][] matrix) {
        this.dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0} };
        int n = matrix.length;
        int m = matrix[0].length;
        this.dp = new int[n][m]; 
        int answer = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                // System.out.println("started at "+i+", "+j+" -=-=-=-=-=-=-=-=-=-=-==-------------------------");
                answer = Math.max(answer, dfs(matrix, i, j));
                // print(dp);
            }
        }
        return answer;
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private int dfs(int[][] matrix, int x, int y)
    {
        if (this.dp[x][y]!=0)
        {
            return this.dp[x][y];
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int[] dir : dirs)
        {
            int r = dir[0]+x;
            int c = dir[1]+y;
            if (r>=0 && r<n && c>=0 && c<m && matrix[r][c]>matrix[x][y])
            {
                // System.out.println("Next checking : "+r+", "+c+" number at  : "+matrix[r][c]);
                // print(this.dp);
                this.dp[x][y] = Math.max(this.dp[x][y], dfs(matrix, r, c));
            }
        }
        return ++this.dp[x][y];
    }
}