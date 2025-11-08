class Solution {

    private Map<Integer, Queue<Integer>> map;

    public Solution(int[] nums) {
        this.map = new HashMap<>();
        int n = nums.length;
        for (int i=0; i<n; i++)
        {
            map.putIfAbsent(nums[i], new ArrayDeque<>());
            map.get(nums[i]).offer(i);
        }    
    }
    
    public int pick(int target) {
        Queue<Integer> q = this.map.get(target);
        int ans = q.poll();
        q.offer(ans);
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */