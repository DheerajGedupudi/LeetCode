class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int maxExcLast = 0;
        int maxIncLast = nums[0];
        for (int i=1; i<n; i++)
        {
            int max = Math.max(maxExcLast+nums[i], maxIncLast);
            maxExcLast = maxIncLast;
            maxIncLast = max;
        }
        return maxIncLast;
    }
}