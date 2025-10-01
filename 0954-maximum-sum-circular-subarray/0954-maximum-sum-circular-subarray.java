class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int minSumWithCurr = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxSumWithCurr = 0;
        for (int x : nums)
        {
            sum += x;
            minSumWithCurr += x;
            minSum = Math.min(minSum, minSumWithCurr);
            if (minSumWithCurr>0)
            {
                minSumWithCurr = 0;
            }
            
            maxSumWithCurr += x;
            maxSum = Math.max(maxSum, maxSumWithCurr);
            if (maxSumWithCurr<0)
            {
                maxSumWithCurr = 0;
            }
        }
        //if all negative
        if (minSum==sum)
        {
            //result of original kadane
            return maxSum;
        }
        int maxSum2 = sum-minSum;
        return Math.max(maxSum, maxSum2);
    }
}