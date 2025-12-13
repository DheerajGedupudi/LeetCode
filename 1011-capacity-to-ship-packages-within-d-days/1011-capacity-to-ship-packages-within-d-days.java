class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        for (int w : weights)
        {
            low = Math.max(low, w);
        }
        int high = Integer.MAX_VALUE;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (possible(weights, days, mid))
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

    private boolean possible(int[] weights, int maxDays, int cap)
    {
        int n = weights.length;
        int days = 1;
        for (int i=0; i<n; i++)
        {
            int j = i;
            int sum = 0;
            while(j<n)
            {
                sum += weights[j];
                if (sum>cap)
                {
                    days++;
                    i = j-1;
                    break;
                }
                i = j;
                j++;
            }
        }
        // System.out.println("cap : "+cap+" -> days : "+days);
        return days<=maxDays;
    }
}