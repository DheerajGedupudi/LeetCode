class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        int n = prices.length;
        for (int i=0; i<n; i++)
        {
            sum += (long)prices[i]*strategy[i];
        }
        max = Math.max(max, sum);
        int[] strat = Arrays.copyOf(strategy, n);
        for (int i=0; i<k; i++)
        {
            if (i<k/2)
            {
                strat[i] = 0;
            }
            else
            {
                strat[i] = 1;
            }
        }
        for (int i=0; i<n; i++)
        {
            sum -= (long)prices[i]*strategy[i];
            sum += (long)prices[i]*strat[i];
        }
        max = Math.max(max, sum);
        // System.out.println(Arrays.toString(strat)+" -> "+sum);
        for (int i=0; i+k<n; i++)
        {
            //i, make original
            //i+k/2, make 0
            //i+k, make 1
            int ind = i;
            sum -= (long)prices[ind]*strat[ind];
            strat[ind] = strategy[ind];
            sum += (long)prices[ind]*strat[ind];

            ind = i+k/2;
            sum -= (long)prices[ind]*strat[ind];
            strat[ind] = 0;
            sum += (long)prices[ind]*strat[ind];
            
            ind = i+k;
            sum -= (long)prices[ind]*strat[ind];
            strat[ind] = 1;
            sum += (long)prices[ind]*strat[ind];

            max = Math.max(max, sum);
            // System.out.println(Arrays.toString(strat)+" -> "+sum);
        }
        return max;
    }
}