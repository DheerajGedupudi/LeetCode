class Solution {

    private Boolean[] memo;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        reverseArray(nums);
        int n = nums.length;
        int sum_total = 0;
        this.memo = new Boolean[(1<<n)];
        for (int x : nums)
        {
            sum_total += x;
        }
        if (sum_total%k!=0)
        {
            return false;
        }
        int req = sum_total/k;
        return check(nums, k, n, req, 0, 0);
    }

    private boolean check(int[] nums, int k, int n, int req, int mask, int sum)
    {
        //edge cases
        if (mask == (1<<n)-1 && k==0)
        {
            return true;
        }
        if (mask >= (1<<n))
        {
            return false;
        }
        if (this.memo[mask]!=null)
        {
            return this.memo[mask];
        }
        //try each unused
        for (int i=0; i<n; i++)
        {
            if ((mask&(1<<i))==0)
            {
                int mask2 = (mask | (1<<i));
                int sum2 = sum+nums[i];
                if (sum2==req)
                {
                    if (check(nums, k-1, n, req, mask2, 0))
                    {
                        this.memo[mask2] = true;
                        return true;
                    }
                    else
                    {
                        this.memo[mask2] = false;
                    }
                }
                else if (sum2<req)
                {
                    if (check(nums, k, n, req, mask2, sum2))
                    {
                        this.memo[mask2] = true;
                        return true;
                    }
                    else
                    {
                        this.memo[mask2] = false;
                    }
                }
            }
        }
        this.memo[mask] = false;
        return false;
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