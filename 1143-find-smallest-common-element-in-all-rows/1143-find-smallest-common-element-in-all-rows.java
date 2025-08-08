class Solution {
    public int smallestCommonElement(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        for (int i=0; i<m; i++)
        {
            int x = mat[0][i];
            boolean flag = true;
            for (int j=1; j<n; j++)
            {
                if (binSearch(mat[j], x)==false)
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
            {
                return x;
            }
        }
        return -1;
    }

    private boolean binSearch(int[] row, int target)
    {
        int n = row.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (row[mid]==target)
            {
                return true;
            }
            else if (row[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;
    }
}