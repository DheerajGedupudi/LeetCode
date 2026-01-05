class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int negs = 0;
        int zeros = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int x = matrix[i][j];
                if (x==0)
                {
                    zeros++;
                }
                if (x<0)
                {
                    negs++;
                }
                x = Math.abs(x);
                min = Math.min(min, x);
                sum += x;
            }
        }
        if (zeros>0)
        {
            return sum;
        }
        if (negs%2==1)
        {
            return sum-(2*min);
        }
        return sum;
    }
}