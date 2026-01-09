class Solution {

    private Integer[][] memo;

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int nonEmpty = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                int prod = nums1[i]*nums2[j];
                nonEmpty = Math.max(nonEmpty, prod);
            }
        }
        this.memo = new Integer[n+1][m+1];
        int withEmpty = dfs(0,0,nums1,nums2);
        if (nonEmpty<0)
        {
            return nonEmpty;
        }
        return withEmpty;
    }

    private int dfs(int x, int y, int[] nums1, int[] nums2)
    {
        int n = nums1.length;
        int m = nums2.length;
        if (x>=n)
        {
            return 0;
        }
        if (y>=m)
        {
            return 0;
        }
        if (this.memo[x][y]!=null)
        {
            return this.memo[x][y];
        }
        //x,y, use
        int max = dfs(x+1, y+1, nums1, nums2)+nums1[x]*nums2[y];
        //x+1, y
        max = Math.max(max, dfs(x+1, y, nums1, nums2)+0);
        //x, y+1
        max = Math.max(max, dfs(x, y+1, nums1, nums2)+0);
        this.memo[x][y] = max;
        return max;
    }
}

/*

   2 -6   7
.3 6 -18 21
-2 -4 12 -14

*/