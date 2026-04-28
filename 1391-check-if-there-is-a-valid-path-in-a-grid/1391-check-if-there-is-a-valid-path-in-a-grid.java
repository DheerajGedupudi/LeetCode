class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Road> q = new LinkedList<>();
        q.offer(getRoad(grid[0][0], 0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        while(q.isEmpty()==false)
        {
            Road curr = q.poll();
            if (curr.cell[0]==n-1 && curr.cell[1]==m-1)
            {
                return true;
            }
            for (Direction side : new Direction[]{curr.s1, curr.s2})
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
                    Road next = getRoad(grid[r][c], r, c);
                    if (isConnected(curr, next, side))
                    {
                        if (r==n-1 && c==m-1)
                        {
                            return true;
                        }
                        q.offer(next);
                        visited[r][c] = true;
                    }
                }
            }
        }
        return false;
    }

    private Road getRoad(int dir, int i, int j)
    {
        if (dir==1)
        {
            return new Road(new int[]{i, j}, Direction.left, Direction.right);
        }
        else if (dir==2)
        {
            return new Road(new int[]{i, j}, Direction.top, Direction.bottom);
        }
        else if (dir==3)
        {
            return new Road(new int[]{i, j}, Direction.left, Direction.bottom);
        }
        else if (dir==4)
        {
            return new Road(new int[]{i, j}, Direction.right, Direction.bottom);
        }
        else if (dir==5)
        {
            return new Road(new int[]{i, j}, Direction.top, Direction.left);
        }
        else if (dir==6)
        {
            return new Road(new int[]{i, j}, Direction.top, Direction.right);
        }
        return null;
    }

    private int[] getNextDir(int[] curr, Direction dir)
    {
        int[] ans = Arrays.copyOf(curr, 2);
        if (dir.equals(Direction.top))
        {
            ans[0]--;
        }
        else if (dir.equals(Direction.bottom))
        {
            ans[0]++;
        }
        else if (dir.equals(Direction.left))
        {
            ans[1]--;
        }
        else if (dir.equals(Direction.right))
        {
            ans[1]++;
        }
        return ans;
    }

    private boolean isConnected(Road last, Road curr, Direction lastSide)
    {
        Direction nextPipeSide = getOpp(lastSide);
        if (curr.s1!=null && curr.s1.equals(nextPipeSide))
        {
            return true;
        }
        if (curr.s2!=null && curr.s2.equals(nextPipeSide))
        {
            return true;
        }
        return false;
    }

    private Direction getOpp(Direction dir)
    {
        if (dir.equals(Direction.top))
        {
            return Direction.bottom;
        }
        if (dir.equals(Direction.bottom))
        {
            return Direction.top;
        }
        if (dir.equals(Direction.left))
        {
            return Direction.right;
        }
        if (dir.equals(Direction.right))
        {
            return Direction.left;
        }
        return null;
    }
}

class Road
{
    int[] cell;
    Direction s1;
    Direction s2;
    // Direction.top, Direction.bottom, Direction.left, Direction.right

    Road(int[] cell, Direction s1, Direction s2)
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

enum Direction
{
    top, bottom, left, right;
}