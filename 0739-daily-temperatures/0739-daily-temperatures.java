class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] tempIndex = new int[101];
        Arrays.fill(tempIndex, Integer.MAX_VALUE);
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i=n-1; i>=0; i--)
        {
            int minIndex = Integer.MAX_VALUE;
            for (int t=temperatures[i]+1; t<=100; t++)
            {
                minIndex = Math.min(minIndex, tempIndex[t]);
            }
            if (minIndex!=Integer.MAX_VALUE)
            {
                ans[i] = minIndex-i;
            }
            tempIndex[temperatures[i]] = i;
        }
        return ans;
    }
}