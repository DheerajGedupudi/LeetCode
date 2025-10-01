/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return construct(grid, 0, n-1, 0, m-1);
    }

    private Node construct(int[][] grid, int row1, int row2, int col1, int col2)
    {
        if (row1>row2 || col1>col2)
        {
            return null;
        }
        boolean found0 = false;
        boolean found1 = false;
        for (int i=row1; i<=row2; i++)
        {
            for (int j=col1; j<=col2; j++)
            {
                if (grid[i][j]==0)
                {
                    found0 = true;
                }
                else
                {
                    found1 = true;
                }
            }
        }
        if (found0^found1)
        {
            return new Node(found1, true, null, null, null, null);
        }
        else
        {
            int midRow = (row1+row2)/2;
            int midCol = (col1+col2)/2;
            Node tl = construct(grid, row1, midRow, col1, midCol);
            Node tr = construct(grid, row1, midRow, midCol+1, col2);
            Node bl = construct(grid, midRow+1, row2, col1, midCol);
            Node br = construct(grid, midRow+1, row2, midCol+1, col2);
            return new Node(found1, false, tl, tr, bl, br);
        }

    }
}