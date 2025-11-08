class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int counter = 0;
        for (int i=0; i<n; i++)
        {
            for (int j=i+1; j<n; j++)
            {
                // getUpper
                int sum = nums[i]+nums[j];
                int low = j+1;
                int high = n-1;
                //get highest lower than sum
                int upper = 0;
                while(low<=high)
                {
                    int mid = low + (high-low)/2;
                    if (nums[mid]<sum)
                    {
                        upper = mid;
                        low = mid+1;
                    }
                    else
                    {
                        high = mid-1;
                    }
                }
                int found = upper-j;
                // System.out.println(nums[i]+" "+nums[j]+" found : "+(found)+", upper : "+upper);
                if (found>0)
                {
                    counter += (found);
                }
            }   
        }
        return counter;
    }
}