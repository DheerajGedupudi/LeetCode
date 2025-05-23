class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        //acknowledge the first skip a* = > ""
        for (int j=2; j<=m; j++)
        {
            if (p.charAt(j-1)=='*' && dp[0][j-2])
            {
                dp[0][j] = true;
            }
        }
        // print(dp);
        for (int i=1; i<=n; i++)
        {
            char c = s.charAt(i-1);
            for (int j=1; j<=m; j++)
            {
                // System.out.println("check match : "+s.substring(0,i)+" <=> "+p.substring(0,j));
                char match = p.charAt(j-1);
                //same letter or '.'
                if (c==match || match=='.')
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                if (match=='*')
                {
                    //last and current same? , take continue with prev match
                    char lastMatch = p.charAt(j-2);
                    //same letter match / dot match
                    if (c==lastMatch || lastMatch=='.')
                    {
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-1];
                    }
                    //nothing to match, consider last states, a* = aa / a* = "a" / a* = ""
                    {
                        dp[i][j] = dp[i][j] || dp[i][j-1] || dp[i][j-2];
                    }
                }
                // print(dp);
            }
        }
        return dp[n][m];
    }

    private void print(boolean[][] grid)
    {
        for (boolean[] row : grid)
        {
            for (boolean cell : row)
            {
                System.out.print((cell?"T":"F")+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}