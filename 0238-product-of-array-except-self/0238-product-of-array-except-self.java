class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int prod = 1;
        for (int i=0; i<n; i++)
        {
            prod *= nums[i];
            left[i] = prod;
        } 
        prod = 1;
        for (int i=n-1; i>=0; i--)
        {
            prod *= nums[i];
            right[i] = prod;
        } 
        int[] result = new int[n];
        for (int i=0; i<n; i++)
        {
            int leftProd = 1;
            int rightProd = 1;
            if (i>0)
            {
                leftProd = left[i-1];
            }
            if (i<n-1)
            {
                rightProd = right[i+1];
            }
            result[i] = leftProd*rightProd;
        }
        return result;
    }
}