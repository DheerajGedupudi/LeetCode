class Solution {
    public int countIslands(int[][] grid, int k) {
        int counter = 0;
        Queue<Integer> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (grid[i][j]!=0 && visited[i][j]==false)
                {
                    q.clear();
                    q.offer(i);
                    q.offer(j);
                    long sum = grid[i][j];
                    visited[i][j] = true;
                    while(q.isEmpty()==false)
                    {
                        int x = q.poll();
                        int y = q.poll();
                        for (int[] dir : dirs)
                        {
                            int r = x+dir[0];
                            int c = y+dir[1];
                            if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && grid[r][c]!=0)
                            {
                                sum += grid[r][c];
                                q.offer(r);
                                q.offer(c);
                                visited[r][c] = true;
                            }
                        }
                    }
                    if (sum%(long)k==0)
                    {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
}