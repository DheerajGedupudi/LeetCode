class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] count = new boolean[2001];
        for (int x : nums)
        {
            count[x] = true;
        }
        for (int i=original; i<2001; i=i*2)
        {
            if (count[i]==false)
            {
                return i;
            }
        }
        return -1;
    }
}