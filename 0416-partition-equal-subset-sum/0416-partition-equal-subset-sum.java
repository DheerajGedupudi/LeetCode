class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int x : nums)
        {
            sum += x;
        }
        if (sum%2!=0)
        {
            return false;
        }
        int req = sum/2;
        boolean[] prevRow = new boolean[req+1];
        boolean[] currRow = new boolean[req+1];
        prevRow[0] = true;
        currRow[0] = true;
        for (int x : nums)
        {
            for (int i=0; i<=req; i++)
            {
                if (prevRow[i] || i>=x && prevRow[i-x])
                {
                    currRow[i] = true;
                }
            }
            prevRow = currRow;
            currRow = new boolean[req+1];
            // System.out.println(Arrays.toString(prevRow));
        }
        return prevRow[req];
    }
}

/*

req = sum/2;




*/
