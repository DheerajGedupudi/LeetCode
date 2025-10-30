class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = -1;
        int max = nums[n-1];
        for (int i=n-2; i>=0; i--)
        {
            if (nums[i]<max)
            {
                index = i;
                break;
            }
            max = Math.max(max, nums[i]);
        }
        if (index==-1)
        {
            reverse(nums, 0, n-1);
            return;
        }
        //look for next smallest num
        int index2 = -1;
        for (int i=index; i<n; i++)
        {
            if (nums[i]>nums[index])
            {
                if (index2==-1)
                {
                    index2 = i;
                }
                else
                {
                    if (nums[i]<=nums[index2])
                    {
                        index2 = i;
                    }
                }
            }
        }
        //swap them
        int temp = nums[index];
        nums[index] = nums[index2];
        nums[index2] = temp;
        //reverse the remaining
        reverse(nums, index+1, n-1);
    }

    private void reverse(int[] nums, int low, int high)
    {
        while(low<high)
        {
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}


/*

[x,y,z]
.- - - 


[1,5,2,4,3]

[1,5,3,2,4]





*/