class Solution {
    public boolean isConsecutive(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x : nums)
        {
            min = Math.min(min, x);
        }
        int n = nums.length;
        int[] count = new int[n];
        for (int i=0; i<n; i++)
        {
            int index = nums[i]-min;
            if (index>=0 && index<n)
            {
                count[index]++;
            }
            // System.out.println(Arrays.toString(nums));
        }
        for (int x : count)
        {
            if (x!=1)
            {
                return false;
            }
        }
        return true;
    }
}