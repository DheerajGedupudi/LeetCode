class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        for (int i=k; i<=n-k; i++)
        {
            // System.out.println((i-k)+" -> "+(i-1)+" ,,,,, "+i+" -> "+(i+k-1));
            //first k
            boolean check1 = true;
            for (int a=i-k; a<i-1; a++)
            {
                if (nums.get(a)>=nums.get(a+1))
                {
                    check1 = false;
                    break;
                }
            }
            //next k
            boolean check2 = true;
            for (int a=i; a<i+k-1; a++)
            {
                if (nums.get(a)>=nums.get(a+1))
                {
                    check2 = false;
                    break;
                }
            }
            if (check1 && check2)
            {
                return true;
            }
        }
        return false;
    }
}