class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] grid = new int[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                grid[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        grid[0][0] = 0;
        Queue<int[]> q = new PriorityQueue<>((a,b)->(moveTime[a[0]][a[1]]-moveTime[b[0]][b[1]]));
        q.offer(new int[]{0,0,0});
        while(q.isEmpty()==false)
        {
            int[] curr = q.poll();
            for (int[] dir : dirs)
            {
                int r = curr[0]+dir[0];
                int c = curr[1]+dir[1];
                if (r>=0 && r<n && c>=0 && c<m)
                {
                    int enterTime = curr[2];
                    if (moveTime[r][c]>enterTime)
                    {
                        enterTime = moveTime[r][c];
                    }
                    enterTime++;
                    if (enterTime < grid[r][c])
                    {
                        grid[r][c] = enterTime;
                        q.offer(new int[]{r,c, enterTime});
                    }
                }
            }
        }
        return grid[n-1][m-1];
    }
}