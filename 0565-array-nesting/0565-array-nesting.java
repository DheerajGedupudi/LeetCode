class Solution {

    private int[] memo;

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        this.memo = new int[n];
        int max = 0;
        for (int i=0; i<n; i++)
        {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            max = Math.max(max, getDepth(nums, i, visited));
        }
        return max;
    }

    private int getDepth(int[] nums, int index, boolean[] visited)
    {
        int n = nums.length;
        if (this.memo[index]!=0)
        {
            return this.memo[index];
        }
        int number = nums[index];
        int depth = 0;
        if (visited[number]==false)
        {
            visited[number] = true;
            depth = getDepth(nums, number, visited);
        }
        this.memo[index] = depth+1;
        return this.memo[index];
    }
}