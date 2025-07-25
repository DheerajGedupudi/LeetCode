class Solution {
    
    private int counter;

    public int findTargetSumWays(int[] nums, int target) {
        this.counter = 0;
        helper(nums, 0, target);
        return this.counter;
    }

    private void helper(int[] nums, int index, int target)
    {
        int n = nums.length;
        if (index==n)
        {
            if (target==0)
            {
                this.counter++;
            }
            return;
        }
        helper(nums, index+1, target+nums[index]);
        helper(nums, index+1, target-nums[index]);
    }
}


/*
. [1,1,1,1,1]
- -1-1-1-1-1
+ +1+1+1+1+1


*/