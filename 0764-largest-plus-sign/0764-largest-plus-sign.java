class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        boolean[][] map = new boolean[n][n];
        for (int[] mine : mines)
        {
            map[mine[0]][mine[1]] = true;
        }
        int[][] top = new int[n][n];
        int[][] bottom = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        //top
        for (int j=0; j<n; j++)
        {
            if (!map[0][j])
            {
                top[0][j] = 1;
            }
        }
        for (int i=1; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                top[i][j] = top[i-1][j]+1;
                if (map[i][j])
                {
                    top[i][j] = 0;
                }
            }
        }
        //bottom
        for (int j=0; j<n; j++)
        {
            if (!map[n-1][j])
            {
                bottom[n-1][j] = 1;
            }
        }
        for (int i=n-2; i>=0; i--)
        {
            for (int j=0; j<n; j++)
            {
                bottom[i][j] = bottom[i+1][j]+1;
                if (map[i][j])
                {
                    bottom[i][j] = 0;
                }
            }
        }
        //left
        for (int i=0; i<n; i++)
        {
            if (!map[i][0])
            {
                left[i][0] = 1;
            }
        }
        for (int j=1; j<n; j++)
        {
            for (int i=0; i<n; i++)
            {
                left[i][j] = left[i][j-1]+1;
                if (map[i][j])
                {
                    left[i][j] = 0;
                }
            }
        }
        //right
        for (int i=0; i<n; i++)
        {
            if (!map[i][n-1])
            {
                right[i][n-1] = 1;
            }
        }
        for (int j=n-2; j>=0; j--)
        {
            for (int i=0; i<n; i++)
            {
                right[i][j] = right[i][j+1]+1;
                if (map[i][j])
                {
                    right[i][j] = 0;
                }
            }
        }
        // print(top);
        // print(bottom);
        // print(left);
        // print(right);
        int result = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                int curr = top[i][j];
                curr = Math.min(curr, bottom[i][j]);
                curr = Math.min(curr, left[i][j]);
                curr = Math.min(curr, right[i][j]);
                result = Math.max(result, curr);
            }
        }
        return result;
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}