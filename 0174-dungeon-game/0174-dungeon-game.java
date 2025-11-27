class Solution {
    
    private int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        this.memo = new int[n][m];
        for (int i=0; i<n; i++)
        {
            Arrays.fill(this.memo[i], 1);
        }
        int neg = helper(dungeon, 0, 0);
        return (neg*-1)+1;
    }

    private int helper(int[][] dungeon, int x, int y)
    {
        int n = dungeon.length;
        int m = dungeon[0].length;
        if (this.memo[x][y]!=1)
        {
            return this.memo[x][y];
        }
        if (x==n-1 && y==m-1)
        {
            return Math.min(0, dungeon[x][y]);
        }
        long right = Integer.MIN_VALUE;
        //to right
        if (y+1<m)
        {
            right = helper(dungeon, x, y+1);
        }
        long bottom = Integer.MIN_VALUE;
        //to bottom
        if (x+1<n)
        {
            bottom = helper(dungeon, x+1, y);
        }
        // System.out.println("-- to right : "+right);
        // System.out.println("-- to bottom : "+bottom);
        long neg = Integer.MIN_VALUE;
        long sum = right+dungeon[x][y];
        sum = Math.min(0, sum);
        neg = Math.max(neg, sum);
        sum = bottom+dungeon[x][y];
        sum = Math.min(0, sum);
        neg = Math.max(neg, sum);
        this.memo[x][y] = (int)neg;
        return this.memo[x][y];

    } 
}