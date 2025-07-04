class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int last = Integer.MIN_VALUE;
        for (int x : nums)
        {
            int num = Math.max(x-k, last+1);
            if (num<=x+k)
            {
                last = num;
                count++;
            }
        }
        return count;
    }
}