class Solution {

    private int[][] prefixRow;
    private int[][] prefixCol;

    public int largestMagicSquare(int[][] grid) {
        initiatePrefixes(grid);
        int n = grid.length;
        int m = grid[0].length;
        int k = Math.min(n, m);
        while(k>1)
        {
            for (int i=0; i+k<=n; i++)
            {
                for (int j=0; j+k<=m; j++)
                {
                    if (magicCheck(grid, i, j, k))
                    {
                        // System.out.println(i+", "+j+" found : "+k);
                        return k;
                    }
                }
            }
            k--;
        }
        return 1;
    }

    private boolean magicCheck(int[][] grid, int x, int y, int k)
    {
        int sum = rowCheck(grid, x, y, k);
        return sum == colCheck(grid, x, y, k) && sum == diagCheck(grid, x, y, k);
    }

    private int rowCheck(int[][] grid, int x, int y, int k)
    {
        // 1st row
        int sum = prefixRow[x+1][y+k]-prefixRow[x+1][y];
        // 2nd and 3rd row
        for (int i=x+1; i<x+k; i++)
        {
            int sum2 = prefixRow[i+1][y+k]-prefixRow[i+1][y];
            if (sum!=sum2)
            {
                return -1;
            }
        }
        return sum;
    }

    private int colCheck(int[][] grid, int x, int y, int k)
    {
        // 1st col
        int sum = prefixCol[x+k][y+1]-prefixCol[x][y+1];
        // 2nd and 3rd row
        for (int j=y+1; j<y+k; j++)
        {
            int sum2 = prefixCol[x+k][j+1]-prefixCol[x][j+1];
            if (sum!=sum2)
            {
                return -2;
            }
        }
        return sum;
    }

    private int diagCheck(int[][] grid, int x, int y, int k)
    {
        int sum = 0;
        // 1st diag
        for (int i=0; i<k; i++)
        {
            sum += grid[x+i][y+i];
        }
        // 2nd diag
        int sum2 = 0;
        for (int i=0; i<k; i++)
        {
            sum2 += grid[x+i][y+(k-1-i)];
        }
        return sum==sum2?sum:-3;
    }

    private void initiatePrefixes(int[][] grid)
    {
        int n = grid.length;
        int m = grid[0].length;
        this.prefixRow = new int[n+1][m+1];
        this.prefixCol = new int[n+1][m+1];
        for (int i=0; i<n; i++)
        {
            int sum = 0;
            for (int j=0; j<m; j++)
            {
                sum += grid[i][j];
                prefixRow[i+1][j+1] = sum;
            }
        }
        for (int j=0; j<m; j++)
        {
            int sum = 0;
            for (int i=0; i<n; i++)
            {
                sum += grid[i][j];
                prefixCol[i+1][j+1] = sum;
            }
        }
    }


}

/*

121
211
112


*/