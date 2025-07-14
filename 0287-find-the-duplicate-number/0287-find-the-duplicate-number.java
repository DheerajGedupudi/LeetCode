class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            int num = Math.abs(nums[i]);
            int numAtIndex = nums[num];
            if (numAtIndex<0)
            {
                return num;
            }
            nums[num] = numAtIndex*-1;
        }
        return -1;
    }
}