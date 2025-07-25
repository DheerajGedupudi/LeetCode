class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return helper(nums, 0, target);
    }

    private int helper(int[] nums, int index, int target)
    {
        int n = nums.length;
        if (index==n)
        {
            if (target==0)
            {
                return 1;
            }
            return 0;
        }
        int x = helper(nums, index+1, target+nums[index]);
        int y = helper(nums, index+1, target-nums[index]);
        return x+y;
    }
}


/*
. [1,1,1,1,1]
- -1-1-1-1-1
+ +1+1+1+1+1


*/