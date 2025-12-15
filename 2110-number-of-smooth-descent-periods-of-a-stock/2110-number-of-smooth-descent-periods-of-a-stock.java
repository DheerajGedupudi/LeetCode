class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long result = n;
        int last = -1;
        long count = 0;
        for (int p : prices)
        {
            if (p+1==last)
            {
                count++;
                result += count;
                // System.out.println("p : "+p+" -> result : "+result);
            }
            else
            {
                count = 0;
            }
            last = p;
        }
        return result;
    }
}