class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int r1 = mat1.length;
        int c1 = mat1[0].length;
        int r2 = mat2.length;
        int c2 = mat2[0].length;
        int[][] result = new int[r1][c2];
        for (int i=0; i<r1; i++)
        {
            for (int j=0; j<c2; j++)
            {
                int sum = 0;
                for (int y=0; y<c1; y++)
                {
                    sum += mat1[i][y]*mat2[y][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}