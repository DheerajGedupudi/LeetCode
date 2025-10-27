class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distinct = new int[n][m];
        int max = 0;
        Map<Integer, Integer> sizeMap = new HashMap<>();

        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        int level = 1;
        
        boolean[][] visited = new boolean[n][m];

        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (grid[i][j]==1 && visited[i][j]==false)
                {
                    Queue<Integer> q = new ArrayDeque<>();
                    int count = 0;
                    q.offer(i);
                    q.offer(j);
                    visited[i][j] = true;
                    while(q.isEmpty()==false)
                    {
                        int qSize = q.size();
                        for (int k=0; k<qSize/2; k++)
                        {
                            int x = q.poll();
                            int y = q.poll();
                            count++;
                            distinct[x][y] = level;
                            for (int[] dir : dirs)
                            {
                                int r = x+dir[0];
                                int c = y+dir[1];
                                if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && grid[r][c]==1)
                                {
                                    q.offer(r);
                                    q.offer(c);
                                    visited[r][c] = true;

                                }
                            }
                        }
                    }
                    sizeMap.put(level, count);
                    max = Math.max(max, count);
                    level++;
                }
            }
        }
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (grid[i][j]==0)
                {
                    Set<Integer> set = new HashSet<>();
                    for (int[] dir : dirs)
                    {
                        int r = i+dir[0];
                        int c = j+dir[1];
                        if (r>=0 && r<n && c>=0 && c<m)
                        {
                            if (grid[r][c]==1)
                            {
                                set.add(distinct[r][c]);
                            }
                        }
                    }
                    int sum = 1;
                    for (int d : set)
                    {
                        sum += sizeMap.get(d);
                    }
                    max = Math.max(max, sum);
                }
            }
        }
        // print(grid);
        // print(distinct);
        // print(size);
        return max;
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

/*

10
01


11
10

33
30

UF

*/