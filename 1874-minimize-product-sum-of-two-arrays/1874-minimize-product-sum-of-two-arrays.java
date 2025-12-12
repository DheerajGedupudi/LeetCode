class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        countSort(nums1);
        countSort(nums2);
        int result = 0;
        int n = nums1.length;
        for (int i=0; i<n; i++)
        {
            result += (nums1[i]*nums2[n-1-i]);
        }
        return result;
    }

    private void countSort(int[] nums)
    {
        int[] count = new int[101];
        for (int x : nums)
        {
            count[x]++;
        }
        int number = 0;
        int index = 0;
        while(number<=100)
        {
            while(count[number]>0)
            {
                nums[index++] = number;
                count[number]--;
            }
            number++;
        }
    }
}