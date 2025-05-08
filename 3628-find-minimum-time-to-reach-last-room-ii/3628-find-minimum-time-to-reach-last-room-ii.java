class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] minTime = new int[n][m];
        for (int[] row : minTime)
        {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        minTime[0][0] = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 0));
        while(q.isEmpty()==false)
        {
            Node curr = q.poll();
            int nextTime = 1;
            if (curr.lastTime==1)
            {
                nextTime = 2;
            }
            for (int[] dir : dirs)
            {
                int r = curr.x+dir[0];
                int c = curr.y+dir[1];
                if (r>=0 && r<n && c>=0 && c<m)
                {
                    int moveTimeReq = Math.max(minTime[curr.x][curr.y], moveTime[r][c]);
                    moveTimeReq += nextTime;
                    if (moveTimeReq<minTime[r][c])
                    {
                        minTime[r][c] = moveTimeReq;
                        q.offer(new Node(r, c, nextTime));
                    }

                }
            }
        }
        // print(moveTime);
        // print(minTime);
        return minTime[n-1][m-1];
    }

    void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}

class Node 
{
    int x;
    int y;
    int lastTime;

    Node(int x, int y, int lastTime)
    {
        this.x = x;
        this.y = y;
        this.lastTime = lastTime;
    }
}