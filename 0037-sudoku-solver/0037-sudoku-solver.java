class Solution {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int x, int y)
    {
        if (x==9)
        {
            // print(board);
            return true;
        }
        if (board[x][y]=='.')
        {
            for (int i=1; i<=9; i++)
            {
                char target = (char)(i+'0');
                if (canPlace(board, x, y, target))
                {
                    board[x][y] = target;
                    int r = x;
                    int c = y+1;
                    // print(board);
                    if (c==9)
                    {
                        c = 0;
                        r++;
                    }
                    if (backtrack(board, r, c))
                    {
                        return true;
                    }
                    board[x][y] = '.';
                }
            }
        }
        else
        {
            int r = x;
            int c = y+1;
            if (c==9)
            {
                c = 0;
                r++;
            }
            if (backtrack(board, r, c))
            {
                return true;
            }
        }
        return false;
    }

    private boolean canPlace(char[][] board, int x, int y, char target)
    {
        //row check
        for (int col=0; col<9; col++)
        {
            if (board[x][col]==target)
            {
                return false;
            }
        }
        //column check
        for (int row=0; row<9; row++)
        {
            if (board[row][y]==target)
            {
                return false;
            }
        }
        //box check
        int xStart = 0;
        int yStart = 0;
        while (x>=xStart+3)
        {
            xStart += 3;
        }
        while (y>=yStart+3)
        {
            yStart += 3;
        }
        for (int row=xStart; row<xStart+3; row++)
        {
            for (int col=yStart; col<yStart+3; col++)
            {
                if (board[row][col]==target)
                {
                    return false;
                }
            }
        }
        return true;
    }

    void print(char[][] board)
    {
        for (char[] row : board)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------------------------------------------");
    }
}