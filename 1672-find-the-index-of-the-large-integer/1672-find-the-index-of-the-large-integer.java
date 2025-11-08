/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int len = reader.length();
        return search(reader, 0, len-1);
    }

    private int search(ArrayReader reader, int low, int high)
    {
        if (low<high)
        {
            int mid = low + (high-low)/2;
            //odd
            if ((high-low+1)%2!=0)
            {
                // System.out.println("odd - checking : "+low+" -> "+high+",  mid : "+mid);
                int x = reader.compareSub(low, mid-1, mid+1, high);
                if (x<0)
                {
                    return search(reader, mid+1, high);
                }
                else if (x==0)
                {
                    return mid;
                }
                else
                {
                    return search(reader, low, mid-1);
                }
            }
            else
            {
                // System.out.println("even - checking : "+low+" -> "+high+",  mid : "+mid);
                int x = reader.compareSub(low, mid, mid+1, high);
                if (x<0)
                {
                    return search(reader, mid+1, high);
                }
                else
                {
                    return search(reader, low, mid);
                }
            }
        }
        return low;
    }
}

/*
         ^
 0 1 2 3 4 5 6 7 8
[5,5,6,5,5,5,5,5,5]



*/