class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            if (i>reach)
            {
                return false;
            }
            if (i==n-1)
            {
                return true;
            }
            int max = i+nums[i];
            if (max>=n-1)
            {
                return true;
            }
            reach = Math.max(max, reach);
        }
        return false;
    }
}