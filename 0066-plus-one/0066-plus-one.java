class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n-1]++;
        int carry = 0;
        if (digits[n-1]>9)
        {
            carry = 1;
            digits[n-1] %= 10;
        }
        for (int i=n-2; i>=0; i--)
        {
            digits[i] += carry;
            if (digits[i]>9)
            {
                carry = 1;
                digits[i] %= 10;
            }
            else
            {
                carry = 0;
            }
        }
        if (carry>0)
        {
            int[] result = new int[n+1];
            for (int i=0; i<n; i++)
            {
                result[i+1] = digits[i];
            }
            result[0] = carry;
            digits = result;
        }
        return digits;
        
    }
}