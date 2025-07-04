class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int last_added = Integer.MIN_VALUE;
        for (int x : nums)
        {
            int start = Math.max(x-k, last_added);
            int end = x+k;
            
            int num = start;
            while(num<=end)
            {
                if (set.contains(num)==false)
                {
                    set.add(num);
                    last_added = num;
                    break;
                }
                num++;
            }
        }
        return set.size();
    }
}