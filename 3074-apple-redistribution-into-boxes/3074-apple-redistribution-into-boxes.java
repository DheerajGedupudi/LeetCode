class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for (int x : apple)
        {
            sum += x;
        }
        int count = 0;
        if (sum<=0)
        {
            return count;
        }
        Arrays.sort(capacity);
        for (int i=capacity.length-1; i>=0; i--)
        {
            sum -= capacity[i];
            count++;
            if (sum<=0)
            {
                return count;
            }
        }
        return -1;
    }
}