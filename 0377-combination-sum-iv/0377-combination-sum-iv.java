class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int j=1; j<=target; j++)
        {
            for (int i=1; i<=n; i++)
            {
                int curr = nums[i-1];
                if (j-curr>=0)
                {
                    dp[j] += dp[j-curr];
                }
            }
        }
        return dp[target];
    }

    private void print(int[][] grid)
    {
        for (int[] row : grid)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}

/*


nums
 target
. 0 1 2 3 4
1 1 1 1 1 1
2 1 1 2 3 5
3 1 1 2 4 7


*/