class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i=0; i<n; i++)
        {
            arr[i] = nums[i];
        }
        for (int[] q : queries)
        {
            get(arr, q);
        }
        long xor = 0;
        for (int i=0; i<n; i++)
        {
            xor ^= arr[i];
        }
        return (int)xor;
    }

    private void get(long[] nums, int[] query)
    {
        int MOD = (int)(Math.pow(10,9))+7;
        int l = query[0];
        int r = query[1];
        int k = query[2];
        int v = query[3];
        for (int i=l; i<=r; i=i+k)
        {
            nums[i] = (nums[i]*v)%MOD;
        }
    }
}