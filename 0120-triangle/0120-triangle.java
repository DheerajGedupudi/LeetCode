class Solution {

    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        this.memo = new int[n][n];
        for (int i=0; i<n; i++)
        {
            Arrays.fill(this.memo[i], Integer.MAX_VALUE);
        }
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int row, int index)
    {
        int total = triangle.size();
        if (row==total)
        {
            return 0;
        }
        if (this.memo[row][index]!=Integer.MAX_VALUE)
        {
            return this.memo[row][index];
        }
        int sum = triangle.get(row).get(index) + Math.min(dfs(triangle, row+1, index), dfs(triangle, row+1, index+1));
        this.memo[row][index] = sum;
        return sum;
    }
}