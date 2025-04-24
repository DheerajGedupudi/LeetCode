class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        for (int i=0; i<=n; i++)
        {
            dp[i][0] = 1;
        }
        for (int i=1; i<=n; i++)
        {
            int curr = nums[i-1];
            for (int j=1; j<=target; j++)
            {
                if (j<curr)
                {
                    dp[i][j] = dp[i-1][j];
                }
                else
                {
                    int sum = 0;
                    for (int k=0; k<i; k++)
                    {
                        int val = nums[k];
                        int col = j-val;
                        sum += dp[i][col];
                    }
                    dp[i][j] = sum;
                }
            }
            // print(dp);
        }
        return dp[n][target];
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