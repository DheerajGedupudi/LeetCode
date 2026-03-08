class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        int m = nums[0].length();
        int max = (1<<m)-1;
        boolean[] set = new boolean[max+1];
        for (int i=0; i<n; i++)
        {
            int num = Integer.parseInt(nums[i], 2);
            set[num] = true;
        }
        // System.out.println(Arrays.toString(set));
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<=max; i++)
        {
            if (set[i]==false)
            {
                sb.append(Integer.toBinaryString(i));
                break;
            }
        }
        sb.reverse();
        while(sb.length()<m)
        {
            sb.append('0');
        }
        return sb.reverse().toString();
    }


}