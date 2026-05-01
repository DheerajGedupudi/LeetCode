class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int lastMultiplier = n-1;
        int sum = 0;
        for (int x : nums)
        {
            sum += x;
        }
        int F = 0;
        for (int i=0; i<n; i++)
        {
            F += (i*nums[i]);
        }
        int answer = F;
        for (int i=0; i<n; i++)
        {
            F += (sum-nums[n-1-i]);
            F -= (lastMultiplier * nums[n-1-i]);
            // System.out.println(F);
            answer = Math.max(answer, F);
        }
        return answer;
    }
}