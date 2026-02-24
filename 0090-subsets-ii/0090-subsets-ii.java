class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0; i<(1<<len); i++)
        {
            List<Integer> list = new ArrayList<>();
            boolean flag = true;
            for (int bit=0; bit<len; bit++)
            {
                if ((i&(1<<bit))!=0)
                {
                    if (bit>0 && nums[bit]==nums[bit-1] && (i&(1<<(bit-1)))==0)
                    {
                        flag = false;
                        break;
                    }
                    list.add(nums[bit]);
                }
            }
            if (flag)
            result.add(list);
        }
        return new ArrayList<>(result);
    }
}