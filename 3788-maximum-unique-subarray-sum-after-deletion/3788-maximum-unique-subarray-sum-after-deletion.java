class Solution {
    public int maxSum(int[] nums) {
        boolean[] count = new boolean[101];
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int x : nums)
        {
            if (x>=0)
            {
                counter++;
                count[x] = true;
            }
            max = Math.max(max, x);
        }
        if (counter==0)
        {
            return max;
        }
        int sum = 0;
        for (int i=0; i<=100; i++)
        {
            if (count[i])
            {
                sum += i;
            }
        }
        return sum;
    }
}