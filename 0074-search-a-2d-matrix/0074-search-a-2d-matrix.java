class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //get row
        //get floor
        int low = 0;
        int high = matrix.length-1;
        int rowIndex = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int currentRowStart = matrix[mid][0];
            if (currentRowStart>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
                rowIndex = mid;
            }
        }
        low = 0;
        high = matrix[0].length-1;
        int colIndex = 0;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int current = matrix[rowIndex][mid];
            if (current==target)
            {
                return true;
            }
            else if (current<target)
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