class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int smallerNumCount = 0;
        int targetCount = 0;
        for (int x : nums)
        {
            if (x<target)
            {
                smallerNumCount++;
            }
            else if (x==target)
            {
                targetCount++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int index = smallerNumCount;
        while(targetCount>0)
        {
            list.add(index);
            index++;
            targetCount--;
        }
        return list;
    }
}