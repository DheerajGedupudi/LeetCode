class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int sum = 0;
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i] = sum;
        }
        // System.out.println("sum : "+sum);
        int count = 0;
        int half = sum/2;
        if (sum%2==0)
        {
            for (int i=0; i<n; i++)
            {
                if (nums[i]==0 && prefix[i]==half)
                {
                    count++;
                }
            }
            return count*2;
        }
        else
        {
            //from left to right
            for (int i=0; i<n; i++)
            {
                if (nums[i]==0 && prefix[i]==half)
                {
                    count++;
                }
            }
            //from right to left
            for (int i=n-1; i>=0; i--)
            {
                if (nums[i]==0 && prefix[i]==half+1)
                {
                    count++;
                }
            }
            return count;
        }
    }
}