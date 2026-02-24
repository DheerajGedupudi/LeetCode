class Solution {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        reverseArray(nums);
        int n = nums.length;
        int sum_total = 0;
        for (int x : nums)
        {
            sum_total += x;
        }
        if (sum_total%k!=0)
        {
            return false;
        }
        int req = sum_total/k;
        int[] dp = new int[(1<<n)];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask=0; mask<(1<<n); mask++)
        {
            if (dp[mask]==-1)
            {
                continue;
            }
            for (int i=0; i<n; i++)
            {
                if ( (mask&(1<<i)) == 0)
                {
                    if (dp[mask]+nums[i]<=req)
                    {
                        int mask2 = mask | (1<<i);
                        dp[mask2] = (dp[mask]+nums[i])%req;
                    }
                }
            }
        }
        return dp[((1<<n)-1)]%req==0;

    }

    private void reverseArray(int[] nums)
    {
        int low = 0;
        int high = nums.length-1;
        while(low<high)
        {
            int swap = nums[low];
            nums[low] = nums[high];
            nums[high] = swap;
            low++;
            high--;
        }
    }
}