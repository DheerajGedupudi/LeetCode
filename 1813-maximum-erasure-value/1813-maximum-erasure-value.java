class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> lastFound = new HashMap<>();
        int n = nums.length;
        int[] prefix = new int[n+1];
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i+1] = sum;
        }
        int p1 = 0;
        int max = nums[0];
        for (int i=0; i<n; i++)
        {
            if (lastFound.containsKey(nums[i]))
            {
                int last = lastFound.get(nums[i])+1;
                if (last>p1)
                {
                    p1 = last;
                }
                // System.out.println(nums[i]+" and  : "+p1+" -> "+i);
            }
            max = Math.max(max, prefix[i+1]-prefix[p1]);
            lastFound.put(nums[i], i);
        }
        return max;
    }
}