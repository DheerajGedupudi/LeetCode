class Solution {
    public char kthCharacter(long k, int[] operations) {
        int ans = 0;
        int num;
        while(k!=1)
        {
            num = 63-Long.numberOfLeadingZeros(k);
            if ( (1L << num)==k)
            {
                num--;
            }
            k = k - (1L << num);
            if (operations[num]!=0)
            {
                ans++;
            }
        }
        return (char)('a'+(ans%26));
    }
}