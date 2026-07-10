class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int sum = 0;
        for (int x : nums)
        {
            sum += x;
            int req = sum-k;
            count += freqMap.getOrDefault(req, 0);
            freqMap.put(sum, freqMap.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}