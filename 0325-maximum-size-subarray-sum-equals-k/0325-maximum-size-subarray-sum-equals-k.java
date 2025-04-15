class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i] = sum;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        for (int i=0; i<n; i++)
        {
            int diff = i-map.getOrDefault(prefix[i]-k, i);
            max = Math.max(max, diff);
            map.putIfAbsent(prefix[i], i);
        }
        return max;
    }
}

/*

[1,-1,5,-2,3]
 1  0 5  3 6 

 k = 3

 map{1=0, 0=-1, 5=2, 3=3}


*/