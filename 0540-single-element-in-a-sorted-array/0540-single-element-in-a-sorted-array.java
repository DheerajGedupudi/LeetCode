class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n==1)
        {
            return nums[0];
        }
        int low = 1;
        int high = n-2;
        if (nums[n-1]!=nums[n-2])
        {
            return nums[n-1];
        }
        if (nums[0]!=nums[1])
        {
            return nums[0];
        }
        int best = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            // odd start
            if (mid%2==0 && nums[mid]==nums[mid+1])
            {
                low = mid+1;
            }
            else if (mid%2!=0 && nums[mid]==nums[mid-1])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
                best = nums[mid];
            }
            // even start

        }
        return best;
    }
}

/*

aabbcdd
--||=^^


*/