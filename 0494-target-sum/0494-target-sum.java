class Solution {
    Map<Integer, Map<Integer, Integer>> memo;

    public int findTargetSumWays(int[] nums, int target) {
        // this.counter = 0;
        int n = nums.length;
        int sum = 0;
        for (int x : nums)
        {
            sum += x;
        }
        this.memo = new HashMap<>();
        return helper(nums, 0, target);
    }

    private int helper(int[] nums, int index, int target)
    {
        if (this.memo.containsKey(index))
        {
            if (this.memo.get(index).containsKey(target))
            {
                return this.memo.get(index).get(target);
            }
        }
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
        this.memo.putIfAbsent(index, new HashMap<>());
        this.memo.get(index).put(target, x+y);
        return x+y;
    }
}


/*
. [1,1,1,1,1]
- -1-1-1-1-1
+ +1+1+1+1+1


*/