class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length==0)
        {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(upper);
            result.add(list);
            return result;
        }
        int diff = nums[0]-lower;
        if (diff>0)
        {
            List<Integer> list = new ArrayList<>();
            list.add(lower);
            list.add(nums[0]-1);
            result.add(list);
        }
        int last = nums[0];
        for (int x : nums)
        {
            diff = x-last;
            if (diff>1)
            {
                List<Integer> list = new ArrayList<>();
                list.add(last+1);
                list.add(x-1);
                result.add(list);
            }
            last = x;
            // System.out.println("at  : "+x+" result : "+result);
        }
        diff = upper-last;
        if (diff>0)
        {
            List<Integer> list = new ArrayList<>();
            list.add(last+1);
            list.add(upper);
            result.add(list);
        }
        return result;
    }
}