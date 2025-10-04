class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] seq = new int[n];
        int max = 0;
        for (int i=0; i<n; i++)
        {
            int x = nums[i];
            seq[i] = 1;
            for (int j=0; j<i; j++)
            {
                if (nums[j]<x)
                {
                    seq[i] = Math.max(seq[i], seq[j]+1);
                }
            }
            max = Math.max(max, seq[i]);
        }
        return max;
    }
}