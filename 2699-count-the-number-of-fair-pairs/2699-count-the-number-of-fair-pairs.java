class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i=0; i<nums.length; i++)
        {
            int left = findLowerBound(nums, i, lower, upper);
            int right = findUpperBound(nums, i, lower, upper);
            if (left!=-1 && right!=-1)
            {
                ans += (right-left+1);
            }
        }
        return ans;
    }

    private int findLowerBound(int[] nums, int index, int lower, int upper)
    {
        int low = index+1;
        int high = nums.length-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if (nums[index] + nums[mid] >= lower)
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return best;
    }

    private int findUpperBound(int[] nums, int index, int lower, int upper)
    {
        int low = index+1;
        int high = nums.length-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if (nums[index] + nums[mid] <= upper)
            {
                best = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return best;
    }

}