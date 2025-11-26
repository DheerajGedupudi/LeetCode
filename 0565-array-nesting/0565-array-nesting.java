class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int max = 0;
        for (int i=0; i<n; i++)
        {
            //visited
            if (visited[i])
            {
                //nothing
                continue;
            }
            //not visited
            int counter = 0;
            int number = i;
            while(visited[number]==false)
            {
                visited[number] = true;
                counter++;
                number = nums[number];
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}