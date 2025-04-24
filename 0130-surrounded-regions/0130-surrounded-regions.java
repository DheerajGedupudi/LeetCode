class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (board[i][j]=='O' && visited[i][j]==false)
                {
                    boolean capturable = check(board, i, j, visited);
                    if (capturable)
                    {
                        capture(board, i, j);
                    }
                    visited[i][j] = true;
                    // print(board);
                    // print(visited);
                }
            }
        }
    }

    private void print(char[][] grid)
    {
        for (char[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private void print(boolean[][] grid)
    {
        for (boolean[] row : grid)
        {
            for (boolean b : row)
            {
                String boom = b?"T":"F";
                System.out.print(boom+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean check(char[][] board, int x, int y, boolean[][] visited)
    {
        int n = board.length;
        int m = board[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visited[x][y] = true;
        boolean surrounded = true;
        while(q.isEmpty()==false)
        {
            int r = q.poll();
            int c = q.poll();
            if (r==0 || r==n-1 || c==0 || c==m-1)
            {
                surrounded = false;
            }
            for (int[] dir : dirs)
            {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if (nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false && board[nr][nc]=='O')
                {
                    q.offer(nr);
                    q.offer(nc);
                    visited[nr][nc] = true;
                }
            }
        }
        return surrounded;
    }

    private void capture(char[][] board, int x, int y)
    {
        int n = board.length;
        int m = board[0].length;
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        q.offer(y);
        visited[x][y] = true;
        while(q.isEmpty()==false)
        {
            int r = q.poll();
            int c = q.poll();
            board[r][c] = 'X';
            for (int[] dir : dirs)
            {
                int nr = r+dir[0];
                int nc = c+dir[1];
                if (nr>=0 && nr<n && nc>=0 && nc<m && visited[nr][nc]==false && board[nr][nc]=='O')
                {
                    q.offer(nr);
                    q.offer(nc);
                    visited[nr][nc] = true;
                }
            }
        }
    }
}