class Solution {

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        if (s.charAt(0)!='0')
        {
            dp[0] = 1;
        }
        else
        {
            return 0;
        }
        for (int i=1; i<n; i++)
        {
            int current = Character.getNumericValue(s.charAt(i));
            if (current>0)
            {
                dp[i] = dp[i-1];
            }
            int last = Character.getNumericValue(s.charAt(i-1));
            int num = (last*10)+current;
            if (num>=10 && num<=26)
            {
                if (i>1)
                {
                    dp[i] += (dp[i-2]);
                }
                else
                {
                    dp[i] += 1;
                }
            }
        }
        return dp[n-1];
    }
}