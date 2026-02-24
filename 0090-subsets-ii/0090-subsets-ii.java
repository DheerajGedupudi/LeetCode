class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i=0; i<(1<<len); i++)
        {
            List<Integer> list = new ArrayList<>();
            for (int bit=0; bit<len; bit++)
            {
                if ((i&(1<<bit))!=0)
                {
                    list.add(nums[bit]);
                }
            }
            result.add(list);
        }
        return new ArrayList<>(result);
    }
}