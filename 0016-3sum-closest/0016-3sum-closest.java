class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++)
        {
            int low = i+1;
            int high = nums.length-1;
            while(low<high)
            {
                int sum = nums[i]+nums[low]+nums[high];
                // System.out.println(nums[i]+", "+nums[low]+", "+nums[high]+" -> "+sum);
                if (sum==target)
                {
                    return sum;
                }
                else if (sum>target)
                {
                    high--;
                }
                else
                {
                    low++;
                }
                int diff = Math.abs(target-sum);
                if (diff<minDiff)
                {
                    minDiff = diff;
                    best = sum;
                }
            }
        }
        return best;
    }
}