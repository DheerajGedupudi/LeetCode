class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        if (matrix[0][0]==1)
        {
            ans++;
        }
        for (int i=1; i<n; i++)
        {
            if (matrix[i][0]==1)
            {
                ans++;
            }
        }
        for (int j=1; j<m; j++)
        {
            if (matrix[0][j]==1)
            {
                ans++;
            }
        }
        for (int i=1; i<n; i++)
        {
            for (int j=1; j<m; j++)
            {
                if (matrix[i][j]==1)
                {
                    int min = Math.min(matrix[i-1][j], matrix[i][j-1]);
                    min = Math.min(min, matrix[i-1][j-1])+1;
                    matrix[i][j] = min;
                    ans += min;
                }
            }
        }
        // for (int[] row : matrix)
        // {
        //     System.out.println(Arrays.toString(row));
        // }
        return ans;
    }
}