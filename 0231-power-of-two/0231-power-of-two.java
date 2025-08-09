class Solution {
    public boolean isPowerOfTwo(int n) {
        int low = 0;
        int high = 32;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            double curr = Math.pow(2, mid);
            if (curr==(double)n)
            {
                return true;
            }
            else if (curr<(double)n)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}