class Solution {
    private Integer[][] memo;
    private int MOD;

    public int knightDialer(int n) {
        this.memo = new Integer[n+1][10];
        this.MOD = (int)Math.pow(10,9)+7;
        int count = 0;
        for (int i=0; i<10; i++)
        {
            count += helper(n, i);
            count %= this.MOD;
        }
        return count;
    }

    private int helper(int level, int index)
    {
        // System.out.println("level : "+level+", index : "+index);
        if (this.memo[level][index]!=null)
        {
            return this.memo[level][index];
        }
        if (level==1)
        {
            return 1;
        }
        int[] nextIndexes = getNext(index);
        int count = 0;
        for (int next : nextIndexes)
        {
            count += helper(level-1, next);
            count %= this.MOD;
        }
        this.memo[level][index] = count;
        return this.memo[level][index];
    }

    private int[] getNext(int x)
    {
        if (x==0)
        {
            return new int[]{4,6};
        }
        else if (x==1)
        {
            return new int[]{6,8};
        }
        else if (x==2)
        {
            return new int[]{7,9};
        }
        else if (x==3)
        {
            return new int[]{4,8};
        }
        else if (x==4)
        {
            return new int[]{3,9,0};
        }
        else if (x==5)
        {
            return new int[0];
        }
        else if (x==6)
        {
            return new int[]{1,7,0};
        }
        else if (x==7)
        {
            return new int[]{2,6};
        }
        else if (x==8)
        {
            return new int[]{1,3};
        }
        else if (x==9)
        {
            return new int[]{2,4};
        }
        return new int[0];
    }
}