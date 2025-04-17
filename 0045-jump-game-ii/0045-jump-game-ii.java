class Solution {
    public int jump(int[] nums) {
        int reach = 0;
        int n = nums.length;
        int[] steps = new int[n];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[0] = 0;
        for (int i=1; i<n; i++)
        {
            for (int j=0; j<i; j++)
            {
                int maxJump = j+nums[j];
                if (maxJump>=i)
                {
                    steps[i] = Math.min(steps[j]+1, steps[i]);
                }
            }
        }
        return steps[n-1];
    }
}