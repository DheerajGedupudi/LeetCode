class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] rowsLeft = new int[n][m];
        int[][] rowsRight = new int[n][m];
        int[][] colsTop = new int[n][m];
        int[][] colsBottom = new int[n][m];
        //rows
        for (int i=0; i<n; i++)
        {
            //left
            int countLeft = 0;
            for (int j=0; j<m; j++)
            {
                if (grid[i][j]=='E')
                {
                    countLeft++;
                }
                else if (grid[i][j]=='W')
                {
                    countLeft = 0;
                }
                else
                {
                    rowsLeft[i][j] = countLeft;
                }
            }
            //right
            int countRight = 0;
            for (int j=m-1; j>=0; j--)
            {
                if (grid[i][j]=='E')
                {
                    countRight++;
                }
                else if (grid[i][j]=='W')
                {
                    countRight = 0;
                }
                else
                {
                    rowsRight[i][j] = countRight;
                }
            }
        }
        //cols
        for (int j=0; j<m; j++)
        {
            //top
            int countTop = 0;
            for (int i=0; i<n; i++)
            {
                if (grid[i][j]=='E')
                {
                    countTop++;
                }
                else if (grid[i][j]=='W')
                {
                    countTop = 0;
                }
                else
                {
                    colsTop[i][j] = countTop;
                }
            }
            //right
            int countBottom = 0;
            for (int i=n-1; i>=0; i--)
            {
                if (grid[i][j]=='E')
                {
                    countBottom++;
                }
                else if (grid[i][j]=='W')
                {
                    countBottom = 0;
                }
                else
                {
                    colsBottom[i][j] = countBottom;
                }
            }
        }
        int max = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int count = rowsLeft[i][j]+rowsRight[i][j]+colsTop[i][j]+colsBottom[i][j];
                max = Math.max(max, count);
            }
        }
        return max;
    }
}