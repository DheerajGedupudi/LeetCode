class Solution {
    public int minOperations(int[][] grid, int x) {
        int row = grid.length;
        int col = grid[0].length;
        int n = row*col;
        if (n==1)
        {
            return 0;
        }
        int offset = grid[0][0] % x;
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
            {
                if (grid[i][j] % x != offset)
                {
                    return -1;
                }
            }
        }
        int[] arr = new int[n];
        for (int i=0; i<row; i++)
        {
            for (int j=0; j<col; j++)
            {
                arr[(i*col)+j] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        int median = arr[n/2];
        int count = 0;
        for (int i=0; i<n; i++)
        {
            count += Math.abs(arr[i]-median)/x;
        }
        return count;
    }
}