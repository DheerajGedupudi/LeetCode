class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int counter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i=0; i<n-2; i++)
        {
            for (int j=0; j<m-2; j++)
            {
                if (uniqCheck(grid, i, j) && rowCheck(grid, i, j) && colCheck(grid, i, j) && diagCheck(grid, i, j))
                {
                    counter++;
                }
            }
        }
        return counter;
    }

    private boolean uniqCheck(int[][] grid, int x, int y)
    {
        boolean[] bits = new boolean[16];
        for (int i=x; i<x+3; i++)
        {
            for (int j=y; j<y+3; j++)
            {
                bits[grid[i][j]] = true;
            }
        }
        for (int i=1; i<10; i++)
        {
            if (bits[i]==false)
            {
                return false;
            }
        }
        return true;
    }

    private boolean rowCheck(int[][] grid, int x, int y)
    {
        int sum = 0;
        // 1st row
        for (int j=y; j<y+3; j++)
        {
            sum += grid[x][j];
        }
        // 2nd and 3rd row
        for (int i=x+1; i<x+3; i++)
        {
            int sum2 = 0;
            for (int j=y; j<y+3; j++)
            {
                sum2 += grid[i][j];
            }
            if (sum!=sum2)
            {
                return false;
            }
        }
        return true;
    }

    private boolean colCheck(int[][] grid, int x, int y)
    {
        int sum = 0;
        // 1st col
        for (int i=x; i<x+3; i++)
        {
            sum += grid[i][y];
        }
        // 2nd and 3rd row
        for (int j=y+1; j<y+3; j++)
        {
            int sum2 = 0;
            for (int i=x; i<x+3; i++)
            {
                sum2 += grid[i][j];
            }
            if (sum!=sum2)
            {
                return false;
            }
        }
        return true;
    }

    private boolean diagCheck(int[][] grid, int x, int y)
    {
        int sum = 0;
        // 1st diag
        for (int i=0; i<3; i++)
        {
            sum += grid[x+i][y+i];
        }
        // 2nd diag
        int sum2 = 0;
        for (int i=0; i<3; i++)
        {
            sum2 += grid[x+i][y+(2-i)];
        }
        return sum==sum2;
    }
}


/*



n x m

n-2 x m-2

4 x 3


2 x 1





*/