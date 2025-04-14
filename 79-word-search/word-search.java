class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = new int[][]{ {0,1}, {1,0}, {0,-1}, {-1,0}};
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (board[i][j]==word.charAt(0))
                {
                    visited[i][j] = true;
                    if (exists(board, word, 1, i, j, dirs, visited))
                    {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean exists(char[][] board, String word, int index, int x, int y, int[][] dirs, boolean[][] visited)
    {
        int n = board.length;
        int m = board[0].length;
        int len = word.length();
        if (index==len)
        {
            return true;
        }
        for (int[] dir : dirs)
        {
            int r = x+dir[0];
            int c = y+dir[1];
            if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false && board[r][c]==word.charAt(index))
            {
                visited[r][c] = true;
                boolean found = exists(board, word, index+1, r, c, dirs, visited);
                if (found)
                {
                    return true;
                }
                visited[r][c] = false;
            }
        }
        return false;
    }
}