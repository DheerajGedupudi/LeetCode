class Solution {

    private int MOD;
    private Integer[][] memo;

    public int colorTheGrid(int m, int n) {
        this.MOD = (int)Math.pow(10, 9)+7;
        int maxState = 1 << (2*m);
        this.memo = new Integer[n+1][maxState];
        return helper(n, m, 0, 0, 0, 0);
    }

    private int helper(int n, int m, int x, int y, int prevState, int currState)
    {
        if (x==n)
        {
            return 1;
        }
        if (y==0)
        {
            if (this.memo[x][prevState]!=null)
            {
                return this.memo[x][prevState];
            }
        }
        if (y==m)
        {
            return helper(n, m, x+1, 0, currState, 0);
        }
        int left = getLeftColor(prevState, y, m);
        int top = getTopColor(currState);
        long sum = 0;
        for (int color=1; color<=3; color++)
        {
            if (color==left) continue;
            if (color==top) continue;
            int nextCurrState = (currState << 2) | color;
            sum +=  helper(n, m, x, y+1, prevState, nextCurrState);
        }
        sum %= this.MOD;
        if (y==0)
        {
            this.memo[x][prevState] = (int)sum;
        }
        return (int)sum;
    }

    private int getTopColor(int currState)
    {
        return currState&3;
    }

    private int getLeftColor(int prevState, int row, int m)
    {
        int shift = (m-1-row)*2;
        return (prevState>>shift)&3;
    }
}
