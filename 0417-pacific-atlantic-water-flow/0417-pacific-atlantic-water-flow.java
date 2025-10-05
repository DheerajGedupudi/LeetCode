class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<Integer> qp = new LinkedList<>();
        Queue<Integer> qa = new LinkedList<>();
        for (int i=0; i<n; i++)
        {
            pacific[i][0] = true;
            qp.offer(i);
            qp.offer(0);
            atlantic[i][m-1] = true;
            qa.offer(i);
            qa.offer(m-1);
        }
        for (int j=0; j<m; j++)
        {
            pacific[0][j] = true;
            qp.offer(0);
            qp.offer(j);
            atlantic[n-1][j] = true;
            qa.offer(n-1);
            qa.offer(j);
        }
        int[][] dirs = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(qp.isEmpty()==false)
        {
            int x = qp.poll();
            int y = qp.poll();
            int h = heights[x][y];
            for (int[] dir : dirs)
            {
                int r = x+dir[0];
                int c = y+dir[1];
                if (r>=0 && r<n && c>=0 && c<m && pacific[r][c]==false && heights[r][c]>=h)
                {
                    pacific[r][c] = true;
                    qp.offer(r);
                    qp.offer(c);
                }
            }
        }
        
        while(qa.isEmpty()==false)
        {
            int x = qa.poll();
            int y = qa.poll();
            int h = heights[x][y];
            for (int[] dir : dirs)
            {
                int r = x+dir[0];
                int c = y+dir[1];
                if (r>=0 && r<n && c>=0 && c<m && atlantic[r][c]==false && heights[r][c]>=h)
                {
                    atlantic[r][c] = true;
                    qa.offer(r);
                    qa.offer(c);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (pacific[i][j] && atlantic[i][j])
                {
                    result.add(Arrays.asList(i,j) );
                }
            }
        }
        return result;
    }
}