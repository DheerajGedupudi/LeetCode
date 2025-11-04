class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int index = 0;
        int distinctIndex = 0;
        while(index<n)
        {
            if (nums[index]!=nums[distinctIndex])
            {
                nums[++distinctIndex] = nums[index];
            }
            index++;
        }
        //return according to 1 index;
        return ++distinctIndex;
    }
}


/*
           i
   j
[0,1,1,1,1,2,2,3,3,4]





*/