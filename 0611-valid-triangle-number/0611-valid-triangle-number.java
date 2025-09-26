class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            for (int j=i+1; j<n; j++)
            {
                int sum = nums[i]+nums[j];
                //binary search
                int low = j+1;
                int high = n-1;
                int best = j;
                while(low<=high)
                {
                    int mid = low + (high-low)/2;
                    if (nums[mid]>=sum)
                    {
                        high = mid-1;
                    }
                    else
                    {
                        best = mid;
                        low = mid+1;
                    }
                }
                // System.out.println(nums[i]+" "+nums[j]+" count : "+(best-j));
                count += (best-j);
            }
        }
        return count;
    }
}

/*

sorted
a,b,c

a+b>c

*/