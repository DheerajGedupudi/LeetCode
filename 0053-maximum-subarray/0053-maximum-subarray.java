class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxSumWithCurr = 0;
        for (int x : nums)
        {
            maxSumWithCurr += x;
            maxSum = Math.max(maxSum, maxSumWithCurr);
            if (maxSumWithCurr<0)
            {
                maxSumWithCurr = 0;
            }
        }
        return maxSum;
    }
}