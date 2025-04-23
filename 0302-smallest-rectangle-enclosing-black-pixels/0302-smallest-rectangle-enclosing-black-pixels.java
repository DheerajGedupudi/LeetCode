class Solution {
    public int minArea(char[][] image, int x, int y) {
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        int n = image.length;
        int m = image[0].length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (image[i][j]=='1')
                {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }
        int rowDiff = maxRow-minRow+1;
        int colDiff = maxCol-minCol+1;
        return rowDiff*colDiff;
    }
}