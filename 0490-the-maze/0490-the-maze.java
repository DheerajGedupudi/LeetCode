class Solution {

    private int[][] dirs;
    private boolean[][][] visited;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        this.visited = new boolean[n][m][4];
        this.dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};    
        for (int i=0; i<4; i++)
        {
            if (dfs(maze, start[0], start[1], i, destination))
            {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[][] maze, int x, int y, int dirIndex, int[] dest)
    {
        if (visited[x][y][dirIndex])
        {
            return false;
        }
        visited[x][y][dirIndex] = true;
        // System.out.println(x+", "+y+", dirIndex : "+dirIndex);
        int n = maze.length;
        int m = maze[0].length;
        //stop check
        boolean stop = false;
        int r = x+dirs[dirIndex][0];
        int c = y+dirs[dirIndex][1];
        if (r<0 || r>=n || c<0 || c>=m || maze[r][c]==1)
        {
            stop = true;
        }
        if (stop && dest[0]==x && dest[1]==y)
        {
            return true;
        }
        if (stop)
        {
            for (int i=1; i<4; i++)
            {
                int dirIndex2 = (dirIndex+i)%4;
                if (dfs(maze, x, y, dirIndex2, dest))
                {
                    return true;
                }
            }
            return false;
        }
        return dfs(maze, r, c, dirIndex, dest);
    }
}