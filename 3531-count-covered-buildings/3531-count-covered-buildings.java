class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int N = 0;
        for (int[] building : buildings)
        {
            int row = building[0];
            int col = building[1];
            N = Math.max(N, Math.max(row, col)+1);
        }
        int[] rowMin = new int[N];
        int[] rowMax = new int[N];
        int[] colMin = new int[N];
        int[] colMax = new int[N];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(rowMax, Integer.MIN_VALUE);
        Arrays.fill(colMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int[] building : buildings)
        {
            int row = building[0];
            int col = building[1];
            rowMin[row] = Math.min(col, rowMin[row]);
            rowMax[row] = Math.max(col, rowMax[row]);
            colMin[col] = Math.min(row, colMin[col]);
            colMax[col] = Math.max(row, colMax[col]);
        }
        int counter = 0;
        for (int[] building : buildings)
        {
            int row = building[0];
            int col = building[1];
            if (row>colMin[col] && row<colMax[col] && col>rowMin[row] && col<rowMax[row])
            {
                counter++;
            }
        }
        return counter;
    }
}