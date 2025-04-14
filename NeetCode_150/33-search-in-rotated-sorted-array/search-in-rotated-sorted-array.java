class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        //First find intersection of 2 parts.
        int minIndex = getMinIndex(nums);
        //Search in first part.
        int index = binarySearch(nums, 0, minIndex, target);
        if (index!=-1)
        {
            return index;
        }
        //Search in second part.
        index = binarySearch(nums, minIndex, n-1, target);
        if (index!=-1)
        {
            return index;
        }
        return -1;
    }

    private int getMinIndex(int[] nums)
    {
        int n = nums.length;
        if (n==1)
        {
            return 0;
        }
        int low = 0;
        int high = n-1;
        int first = nums[low];
        int last = nums[high];
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int current = nums[mid];
            int prev = nums[(mid-1+n)%n];
            if (prev>current)
            {
                return mid;
            }
            if (current>=first)
            {
                if (current>last)
                {
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int low, int high, int target)
    {
        if (low>high)
        {
            return -1;
        }
        if (low<0 || low>=nums.length || high<0 || high>=nums.length)
        {
            return -1;
        }
        int mid = low + (high-low)/2;
        if (nums[mid]==target)
        {
            return mid;
        }
        else if (nums[mid]<target)
        {
            return binarySearch(nums, mid+1, high, target);
        }
        else
        {
            return binarySearch(nums, low, mid-1, target);
        }
    }
}