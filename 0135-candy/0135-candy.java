class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        for (int i=1; i<n; i++)
        {
            if (ratings[i]>ratings[i-1])
            {
                if (count[i]<=count[i-1])
                {
                    count[i] = count[i-1]+1;
                }
            }
        }
        // System.out.println(Arrays.toString(count));
        for (int i=n-2; i>=0; i--)
        {
            if (ratings[i]>ratings[i+1])
            {
                if (count[i]<=count[i+1])
                {
                    count[i] = count[i+1]+1;
                }
            }
        }
        // System.out.println(Arrays.toString(count));
        int sum = 0;
        for (int x : count)
        {
            sum += x;
        }
        return sum;
    }
}