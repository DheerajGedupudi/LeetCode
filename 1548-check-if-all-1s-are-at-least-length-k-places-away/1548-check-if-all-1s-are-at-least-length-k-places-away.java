class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = Integer.MIN_VALUE;
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            if (nums[i]==1)
            {
                if (i-k<=lastOne)
                {
                    return false;
                }
                lastOne = i;
            }
        }
        return true;
    }
}