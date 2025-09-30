class Solution {
    public int triangularSum(int[] nums) {
        int length = nums.length;
        int[] arr = new int[length];
        while(length>1)
        {
            for (int i=0; i<length-1; i++)
            {
                arr[i] = (nums[i]+nums[i+1])%10;
            }
            nums = arr;
            length--;
        }
        return nums[0];
    }
}