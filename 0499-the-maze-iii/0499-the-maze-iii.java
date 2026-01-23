class Solution {

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int n = maze.length;
        int m = maze[0].length;
        char[] dirNames = new char[]{'r', 'd', 'l', 'u'};
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        String result = "z";
        boolean[][][] visited = new boolean[n][m][4];
        Queue<Path> q = new PriorityQueue<>(Comparator.comparing(Path::getS));
        for (int i=0; i<4; i++)
        {
            int r = ball[0]+dirs[i][0];
            int c = ball[1]+dirs[i][1];
            if (r<0 || r>=n || c<0 || c>=m || maze[r][c]==1)
            {
                continue;
            }
            visited[ball[0]][ball[1]][i] = true;
            visited[r][c][i] = true;
            Path path = new Path(""+dirNames[i], r, c, i);
            q.offer(path);
        }
        int level = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            Queue<Path> q2 = new PriorityQueue<>(Comparator.comparing(Path::getS));
            for (int s=0; s<size; s++)
            {
                Path curr = q.poll();
                if (curr.x==hole[0] && curr.y==hole[1])
                {
                    if (curr.s.compareTo(result)<0)
                    {
                        result = curr.s;
                    }
                }
                boolean wall = false;
                int x1 = curr.x+dirs[curr.dirIndex][0];
                int y1 = curr.y+dirs[curr.dirIndex][1];
                if (x1<0 || x1>=n || y1<0 || y1>=m || maze[x1][y1]==1)
                {
                    wall = true;
                }
                if (wall)
                {
                    // System.out.println("at : "+curr.x+", "+curr.y+" dist : "+level+" s : "+curr.s);
                    for (int i=1; i<4; i++)
                    {
                        int dirIndex2 = (curr.dirIndex+i)%4;
                        int r = curr.x+dirs[dirIndex2][0];
                        int c = curr.y+dirs[dirIndex2][1];
                        if (r<0 || r>=n || c<0 || c>=m || maze[r][c]==1)
                        {
                            continue;
                        }
                        String s2 = curr.s+""+dirNames[dirIndex2];
                        visited[curr.x][curr.y][dirIndex2] = true;
                        if (visited[r][c][dirIndex2]==false)
                        {
                            visited[r][c][dirIndex2] = true;
                            Path child = new Path(s2, r, c, dirIndex2);
                            q2.offer(child);
                        }
                    }
                }
                else
                {
                    if (visited[x1][y1][curr.dirIndex]==false)
                    {
                        visited[x1][y1][curr.dirIndex] = true;
                        Path child = new Path(curr.s, x1, y1, curr.dirIndex);
                        q2.offer(child);
                    }
                }

            }
            level++;
            q = q2;
            if (result.equals("z")==false)
            {
                break;
            }
        }
        if (result.equals("z"))
        {
            result = "impossible";
        }
        return result;
    }
}

class Path
{
    String s;
    int x;
    int y;
    int dirIndex;

    Path(String s, int x, int y, int dirIndex)
    {
        this.s = s;
        this.x = x;
        this.y = y;
        this.dirIndex = dirIndex;
    }

    public String getS()
    {
        return this.s;
    }
}


/*


[0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1],
[0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0],
[1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0],
[0,1,0,*,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1],
[0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0],
[0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0],
[0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1],
[0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,=,0,0],
[1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0],
[0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0],
[0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1],
[0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0],
[1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0],
[0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0],
[0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1],
[0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0],
[1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0],
[0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0,1,0,0,1,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1],
[0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0],
[1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,1,0,0],
[0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1],
[0,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0],
[1,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0],
[0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0],
[0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0]


[0,1,0,0,1,0,0,1,0,0],
[0,0,1,0,0,1,0,0,1,0],
[0,0,0,0,*,0,1,0,0,1],
[0,0,0,0,0,0,1,0,0,1],
[0,1,0,0,1,0,0,1,0,0],
[0,0,1,0,0,1,0,0,0,0],
[0,0,0,0,0,0,1,0,0,0],
[1,0,0,1,0,0,=,0,0,1],
[0,1,0,0,1,0,0,1,0,0],
[0,0,0,0,0,1,0,0,1,0]

*/