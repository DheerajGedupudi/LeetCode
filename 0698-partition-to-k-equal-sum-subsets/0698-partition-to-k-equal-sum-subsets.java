class Solution {

    private Boolean[][] memo;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum_total = 0;
        this.memo = new Boolean[(1<<n)][k+1];
        for (int x : nums)
        {
            sum_total += x;
        }
        // System.out.println("total : "+sum_total);
        if (sum_total%k!=0)
        {
            return false;
        }
        int req = sum_total/k;
        if (req<nums[n-1])
        {
            return false;
        }
        // System.out.println(req);
        // System.out.println(Arrays.toString(nums));
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
        if (this.memo[mask][k]!=null)
        {
            return this.memo[mask][k];
        }
        //backtrack
        if (sum==req)
        {
            boolean ans =  check(nums, k-1, n, req, mask, 0, 0);
            this.memo[mask][k-1] = ans;
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
        if (check(nums, k, n, req, mask, bit+1, sum+(nums[bit])))
        {
            return true;
        }
        if (check(nums, k, n, req, origMask, bit+1, sum))
        {
            return true;
        }
        return false;
    }
}