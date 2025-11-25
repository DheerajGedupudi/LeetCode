class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k%2==0)
        {
            return -1;
        }
        if (k==1)
        {
            return 1;
        }
        int n = 1;
        int count = 1;
        while(n!=0 && count<=k)
        {
            n *= 10;
            n += 1;
            n %= k;
            count++;
        }
        if (n!=0)
        {
            return -1;
        }
        return count;

    }
}