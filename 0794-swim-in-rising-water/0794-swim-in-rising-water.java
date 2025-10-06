class Solution {
    public int swimInWater(int[][] grid) {
        int low = 0;
        int high = 5000;
        int best = high;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (swim(grid, mid))
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return best;
    }

    private boolean swim(int[][] grid, int l)
    {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        if (grid[0][0]<=l)
        {
            q.offer(0);
            q.offer(0);
            visited[0][0] = true;
        }
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(q.isEmpty()==false)
        {
            int x = q.poll();
            int y = q.poll();
            if (x==n-1 && y==m-1)
            {
                return true;
            }
            for (int[] dir : dirs)
            {
                int r = x+dir[0];
                int c = y+dir[1];
                if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && grid[r][c]<=l)
                {
                    if (r==n-1 && c==m-1)
                    {
                        return true;
                    }
                    q.offer(r);
                    q.offer(c);
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }
}