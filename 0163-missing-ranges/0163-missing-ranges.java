class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n==0)
        {
            List<Integer> pair = new ArrayList<>();
            pair.add(lower);
            pair.add(upper);
            result.add(pair);
            return result;
        }
        if (nums[0]>lower)
        {
            List<Integer> pair = new ArrayList<>();
            pair.add(lower);
            pair.add(nums[0]-1);
            result.add(pair);
        }
        for (int i=1; i<n; i++)
        {
            int last = nums[i-1];
            int curr = nums[i];
            if (last+1 < curr)
            {
                List<Integer> pair = new ArrayList<>();
                pair.add(last+1);
                pair.add(curr-1);
                result.add(pair);
            }
        }
        if (nums[n-1]<upper)
        {
            List<Integer> pair = new ArrayList<>();
            pair.add(nums[n-1]+1);
            pair.add(upper);
            result.add(pair);
        }
        return result;
    }
}