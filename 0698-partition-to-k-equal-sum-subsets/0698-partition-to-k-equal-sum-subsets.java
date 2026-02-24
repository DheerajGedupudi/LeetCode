class Solution {

    private Boolean[][] memo;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum_total = 0;
        this.memo = new Boolean[(1<<n)][n+1];
        for (int x : nums)
        {
            sum_total += x;
        }
        if (sum_total%k!=0)
        {
            return false;
        }
        int req = sum_total/k;
        if (req<nums[n-1])
        {
            return false;
        }
        return check(nums, k, n, req, 0, 0, 0);
    }

    private boolean check(int[] nums, int k, int n, int req, int mask, int bit, int sum)
    {
        if (mask == (1<<n)-1 && k==0)
        {
            return true;
        }
        if (mask >= (1<<n))
        {
            return false;
        }
        if (this.memo[mask][bit]!=null)
        {
            return this.memo[mask][bit];
        }
        //backtrack
        if (sum==req)
        {
            boolean ans =  check(nums, k-1, n, req, mask, 0, 0);
            this.memo[mask][0] = ans;
            if (ans)
            {
                return true;
            }
        }
        if (sum>req)
        {
            return false;
        }
        int origMask = mask;
        while(bit<n && (mask & (1<<bit))!=0)
        {
            bit++;
        }
        if (bit>=n)
        {
            return false;
        }
        mask |= (1<<bit);
        boolean ans1 =  check(nums, k, n, req, mask, bit+1, sum+(nums[bit]));
        this.memo[mask][bit+1] = ans1;
        if (ans1)
        {
            return true;
        }
        boolean ans2 = check(nums, k, n, req, origMask, bit+1, sum);
        this.memo[origMask][bit+1] = ans2;
        if (ans2)
        {
            return true;
        }
        return false;
    }
}