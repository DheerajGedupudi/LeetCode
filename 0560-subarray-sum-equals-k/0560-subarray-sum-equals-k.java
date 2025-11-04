class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i] = sum;
        }
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        for (int i=0; i<n; i++)
        {
            int req = prefix[i]-k;
            result += freqMap.getOrDefault(req, 0);
            freqMap.put(prefix[i], freqMap.getOrDefault(prefix[i], 0)+1);
        }
        return result;
    }
}