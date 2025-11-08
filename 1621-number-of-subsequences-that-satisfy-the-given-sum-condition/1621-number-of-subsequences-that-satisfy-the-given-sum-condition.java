class Solution {

    private int[] powers;
    private int MOD;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        this.powers = new int[n+1];
        this.MOD = (int)Math.pow(10, 9)+7;
        long counter = 0;
        for (int i=0; i<n; i++)
        {
            int x = nums[i];
            int req = target-x;
            //get largest less than or equal to req
            int low = i;
            int high = n-1;
            int best = -1;
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                if (nums[mid]<=req)
                {
                    best = mid;
                    low = mid+1;
                }
                else
                {
                    high = mid-1;
                }
            }
            if (best!=-1)
            {
                int found = best-i;
                // System.out.println("for : "+i+" found : "+found);
                counter += getPowerOf2(found);
                counter %= MOD;
            }

        }
        return (int)counter;
    }

    private int getPowerOf2(int n)
    {
        if (this.powers[n]!=0)
        {
            return this.powers[n];
        }
        if (n==1)
        {
            this.powers[1] = 2;
            return 2;
        }
        if (n==0)
        {
            this.powers[0] = 1;
            return 1;
        }
        int x = getPowerOf2(n-1);
        int ans = x<<1;
        ans %= MOD;
        this.powers[n] = ans;
        return ans;

    }
}

/*

[3,3,6,8]


3 -> 8 = 3->  
7

*/