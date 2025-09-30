class Solution {
    public int triangularSum(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums)
        {
            list.add(x);
        }
        while(list.size()>1)
        {
            List<Integer> list2 = new ArrayList<>();
            int len = list.size();
            for (int i=0; i<len-1; i++)
            {
                list2.add((list.get(i)+list.get(i+1))%10);
            }
            list = list2;
        }
        return list.get(0);
    }
}