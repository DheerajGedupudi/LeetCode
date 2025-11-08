class Solution {
    public int findKthPositive(int[] arr, int k) {
        for (int i=1; i<3000; i++)
        {
            if (bs(arr, i)==-1)
            {
                k--;
            }
            if (k==0)
            {
                return i;
            }
        }
        return -1;
    }

    private int bs(int[] arr, int target)
    {
        int low = 0;
        int high = arr.length-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (arr[mid]==target)
            {
                return mid;
            }
            else if (arr[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
}


/*
 1 2 3 4 5 6 7 8 9
[2,3,4,7,11]



*/