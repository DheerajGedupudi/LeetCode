class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int x : nums)
        {
            int digits = countDigits(x);
            if (digits%2==0)
            {
                count++;
            }
        }
        return count;
    }

    private int countDigits(int n)
    {
        int count = 0;
        while(n>0)
        {
            n /= 10;
            count++;
        }
        return count;
    }
}