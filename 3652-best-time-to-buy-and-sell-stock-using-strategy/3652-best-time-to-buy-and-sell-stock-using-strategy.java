class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += (long)prices[i]*strategy[i];
        }
        long max = sum;
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
        // System.out.println(Arrays.toString(strategy)+" "+sum);
        sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += (long)prices[i]*strat[i];
        }
        // System.out.println(Arrays.toString(strat)+" "+sum);
        max = Math.max(max, sum);
        for (int i=0; i+k<n; i++)
        {
            //update w
            int index = i;
            sum -= (long)prices[index]*strat[index];
            strat[index] = strategy[index];
            sum += (long)prices[index]*strat[index];

            //update w + k/2
            index = i+k/2;
            sum -= (long)prices[index]*strat[index];
            strat[index] = 0;
            sum += (long)prices[index]*strat[index];

            //update w + k
            index = i+k;
            sum -= (long)prices[index]*strat[index];
            strat[index] = 1;
            sum += (long)prices[index]*strat[index];
            // System.out.println(Arrays.toString(strat)+" "+sum);

            max = Math.max(max, sum);
        }
        return max;
    }
}


/*

k = 4
k/2 = 2

[0,1,2,3,4,5,6,7,8,9,0]
[0,0,1,1]




*/