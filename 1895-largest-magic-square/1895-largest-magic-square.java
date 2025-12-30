class Solution {
    public int largestMagicSquare(int[][] grid) {
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
        int sum = 0;
        // 1st row
        for (int j=y; j<y+k; j++)
        {
            sum += grid[x][j];
        }
        // 2nd and 3rd row
        for (int i=x+1; i<x+k; i++)
        {
            int sum2 = 0;
            for (int j=y; j<y+k; j++)
            {
                sum2 += grid[i][j];
            }
            if (sum!=sum2)
            {
                return -1;
            }
        }
        return sum;
    }

    private int colCheck(int[][] grid, int x, int y, int k)
    {
        int sum = 0;
        // 1st col
        for (int i=x; i<x+k; i++)
        {
            sum += grid[i][y];
        }
        // 2nd and 3rd row
        for (int j=y+1; j<y+k; j++)
        {
            int sum2 = 0;
            for (int i=x; i<x+k; i++)
            {
                sum2 += grid[i][j];
            }
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
}

/*

121
211
112


*/