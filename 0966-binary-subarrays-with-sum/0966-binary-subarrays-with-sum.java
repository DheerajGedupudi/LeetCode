class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int sum = 0;
        int result = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0,1);
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            int req = sum-goal;
            result += freqMap.getOrDefault(req, 0);
            freqMap.put(sum, freqMap.getOrDefault(sum, 0)+1);
        }
        return result;
    }
}