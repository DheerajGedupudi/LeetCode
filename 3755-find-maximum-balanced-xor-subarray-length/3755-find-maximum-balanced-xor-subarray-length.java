class Solution {
    public int maxBalancedSubarray(int[] nums) {
        int n = nums.length;
        int[] evens = new int[n+1];
        int count = 0;
        int sum = 0;
        int[] prefix = new int[n+1];
        Map<Integer, Map<Integer, Integer>> xorMap = new HashMap<>();
        xorMap.put(0, new HashMap<>());
        xorMap.get(0).put(0, 0);
        //<sum, <even, index>>
        int max = 0;
        for (int i=0; i<n; i++)
        {
            if (nums[i]%2==0)
            {
                count++;
            }
            else
            {
                count--;
            }
            evens[i+1] = count;
            sum ^= nums[i];
            prefix[i+1] = sum;
            if (xorMap.containsKey(sum))
            {
                if (xorMap.get(sum).containsKey(count))
                {
                    int index = xorMap.get(sum).get(count);
                    int len = i-index+1;
                    max = Math.max(len, max);
                }
            }
            xorMap.putIfAbsent(sum, new HashMap<>());
            xorMap.get(sum).putIfAbsent(count, i+1);
        }
        return max;
    }
}