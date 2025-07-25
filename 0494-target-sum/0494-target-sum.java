class Solution {
    private Integer[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums)
        {
            sum += x;
        }
        this.memo = new Integer[n+1][sum*2+1];
        return helper(nums, 0, 0, target, sum);
    }

    private int helper(int[] nums, int index, int sum, int target, int offset)
    {
        if (this.memo[index][offset+sum]!=null)
        {
            return this.memo[index][offset+sum];
        }
        int n = nums.length;
        if (index==n)
        {
            if (target==sum)
            {
                return 1;
            }
            return 0;
        }
        int x = helper(nums, index+1, sum+nums[index], target, offset);
        int y = helper(nums, index+1, sum-nums[index], target, offset);
        this.memo[index][offset+sum] = x+y;
        return x+y;
    }
}


/*
. [1,1,1,1,1]
- -1-1-1-1-1
+ +1+1+1+1+1


*/