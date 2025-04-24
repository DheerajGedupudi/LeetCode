class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int x : nums)
        {
            distinct.add(x);
        }
        int count = 0;
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            Set<Integer> set = new HashSet<>();
            for (int j=i; j<n; j++)
            {
                set.add(nums[j]);
                if (set.size()==distinct.size())
                {
                    count++;
                }
            }
        }
        return count;
    }
}