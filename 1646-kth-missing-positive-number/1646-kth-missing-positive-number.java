class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int missing = arr[mid]-(mid+1);
            if (missing<k)
            {
                low = mid+1;
            }
            else
            {
                if (mid==0)
                {
                    return k;
                }
                int lastMissing = arr[mid-1]-(mid);
                if (lastMissing<k)
                {
                    return arr[mid-1]+(k-lastMissing);
                }
                high = mid-1;
            }
        }
        return k+arr.length;

    }
}