class Solution {
    public int[] shuffle(int[] nums, int n) {
        int i = 0;
        int j = n;
        int index = 0;
        int[] result = new int[n*2];
        while(i<n)
        {
            result[index++] = nums[i++];
            result[index++] = nums[j++];
        }
        return result;
    }
}