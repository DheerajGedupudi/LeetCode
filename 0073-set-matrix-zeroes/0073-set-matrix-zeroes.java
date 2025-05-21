class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (matrix[i][j]==0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i==0)
                    {
                        firstRow = true;
                    }
                    if (j==0)
                    {
                        firstCol = true;
                    }
                }
            }
        }
        for (int i=1; i<n; i++)
        {
            if (matrix[i][0]==0)
            {
                for (int j=1; j<m; j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j=1; j<m; j++)
        {
            if (matrix[0][j]==0)
            {
                for (int i=1; i<n; i++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstRow)
        {
            for (int j=0; j<m; j++)
            {
                matrix[0][j] = 0;
            }
        }
        if (firstCol)
        {
            for (int i=0; i<n; i++)
            {
                matrix[i][0] = 0;
            }
        }
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            for (int num : row)
            {
                System.out.print(num+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}