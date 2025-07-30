class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int last = nums[0];
        int ans = 1;
        int length = 1;
        for (int i=1; i<n; i++)
        {
            //smaller
            //larger
            if (nums[i]>max)
            {
                length = 1;
                max = nums[i];
                ans = length;
            }
            //same
            if (nums[i]==max)
            {
                if (nums[i]==last)
                {
                    length++;
                }
                if (nums[i]!=last)
                {
                    length = 1;
                }
                if (length>ans)
                {
                    ans = length;
                }
            }
            last = nums[i];
        }
        return ans;
    }
}