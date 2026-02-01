class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        Integer min1 = null;
        Integer min2 = null;
        for (int i=1; i<n; i++)
        {
            int x = nums[i];
            //both null
            if (min1==null)
            {
                min1 = x;
                continue;
            }
            //min1 taken
            if (min1!=null && min2==null)
            {
                if (x<min1)
                {
                    min2 = min1;
                    min1 = x;
                }
                else
                {
                    min2 = x;
                }
                continue;
            }
            //both taken
            if (x<min1)
            {
                min2 = min1;
                min1 = x;
            }
            else if (x<min2)
            {
                min2 = x;
            }
        }
        return nums[0]+min1+min2;
    }
}