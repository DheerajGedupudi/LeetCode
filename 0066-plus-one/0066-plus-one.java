class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        int sum = digits[n-1]+1;
        if (sum>9)
        {
            carry = 1;
        }
        digits[n-1] = sum%10;
        for (int i=n-2; i>=0; i--)
        {
            sum = carry+digits[i];
            if (sum>9)
            {
                carry = 1;
            }
            else
            {
                carry = 0;
            }
            digits[i] = sum%10;
        }
        if (carry>0)
        {
            int[] ans = new int[n+1];
            ans[0] = 1;
            for (int i=0; i<n; i++)
            {
                ans[i+1] = digits[i];
            }
            return ans;
        }
        else
        {
            return digits;
        }
    }
}