class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Road[][] map = new Road[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (grid[i][j]==1)
                {
                    map[i][j] = new Road(new int[]{i, j}, "left", "right");
                }
                else if (grid[i][j]==2)
                {
                    map[i][j] = new Road(new int[]{i, j}, "top", "bottom");
                }
                else if (grid[i][j]==3)
                {
                    map[i][j] = new Road(new int[]{i, j}, "left", "bottom");
                }
                else if (grid[i][j]==4)
                {
                    map[i][j] = new Road(new int[]{i, j}, "right", "bottom");
                }
                else if (grid[i][j]==5)
                {
                    map[i][j] = new Road(new int[]{i, j}, "top", "left");
                }
                else if (grid[i][j]==6)
                {
                    map[i][j] = new Road(new int[]{i, j}, "top", "right");
                }
            }
        }
        boolean[][] visited = new boolean[n][m];
        Queue<Road> q = new LinkedList<>();
        q.offer(map[0][0]);
        visited[0][0] = true;
        while(q.isEmpty()==false)
        {
            Road curr = q.poll();
            if (curr.cell[0]==n-1 && curr.cell[1]==m-1)
            {
                return true;
            }
            for (String side : new String[]{curr.s1, curr.s2})
            {
                if (side == null)
                {
                    continue;
                }
                int[] nextDir = getNextDir(curr.cell, side);
                int r = nextDir[0];
                int c = nextDir[1];
                if (r>=0 && r<n && c>=0 && c<m && !visited[r][c])
                {
                    visited[r][c] = true;
                    Road next = map[r][c];
                    if (isConnected(curr, next))
                    {
                        //road also gets closed upon moving forward
                        q.offer(next);
                        visited[r][c] = true;
                    }
                }
            }
            // print(visited);
        }
        return false;
    }

    private int[] getNextDir(int[] curr, String dir)
    {
        int[] ans = Arrays.copyOf(curr, 2);
        if (dir.equals("top"))
        {
            ans[0]--;
        }
        else if (dir.equals("bottom"))
        {
            ans[0]++;
        }
        else if (dir.equals("left"))
        {
            ans[1]--;
        }
        else if (dir.equals("right"))
        {
            ans[1]++;
        }
        return ans;
    }

    private void print(boolean[][] visited)
    {
        for (boolean[] row : visited)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private boolean isConnected(Road last, Road curr)
    {
        // System.out.println("checking: last: "+last+", ------ current : "+curr);
        if (canConnect(last.s1, curr.s1) || canConnect(last.s2, curr.s1))
        {
            curr.s1 = null;
            return true;
        }
        if (canConnect(last.s1, curr.s2) || canConnect(last.s2, curr.s2))
        {
            curr.s2 = null;
            return true;
        }
        return false;
    }

    private boolean canConnect(String dir1, String dir2)
    {
        if (dir1 == null || dir2 == null)
        {
            return false;
        }
        if (dir1.equals("top") && dir2.equals("bottom") || dir1.equals("left") && dir2.equals("right") || dir1.equals("bottom") && dir2.equals("top") || dir1.equals("right") && dir2.equals("left"))
        {
            return true;
        }
        return false;
    }
}

class Road
{
    int[] cell;
    String s1;
    String s2;
    // top, bottom, left, right

    Road(int[] cell, String s1, String s2)
    {
        this.cell = cell;
        this.s1 = s1;
        this.s2 = s2;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(this.cell)+", "+s1+", "+s2+"\n";
    }
}