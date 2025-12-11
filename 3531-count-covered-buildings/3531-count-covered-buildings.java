class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> rowBasedMin = new HashMap<>();
        Map<Integer, Integer> rowBasedMax = new HashMap<>();
        Map<Integer, Integer> colBasedMin = new HashMap<>();
        Map<Integer, Integer> colBasedMax = new HashMap<>();
        for (int[] building : buildings)
        {
            int row = building[0];
            int col = building[1];
            rowBasedMin.putIfAbsent(row, col);
            rowBasedMax.putIfAbsent(row, col);
            colBasedMin.putIfAbsent(col, row);
            colBasedMax.putIfAbsent(col, row);
            rowBasedMin.put(row, Math.min(col, rowBasedMin.get(row)));
            rowBasedMax.put(row, Math.max(col, rowBasedMax.get(row)));
            colBasedMin.put(col, Math.min(row, colBasedMin.get(col)));
            colBasedMax.put(col, Math.max(row, colBasedMax.get(col)));
        }
        // System.out.println("row min : "+rowBasedMin);
        // System.out.println("row max : "+rowBasedMax);
        // System.out.println("col min : "+colBasedMin);
        // System.out.println("col max : "+colBasedMax);
        int counter = 0;
        for (int[] building : buildings)
        {
            int row = building[0];
            int col = building[1];
            int minCol = rowBasedMin.get(row);
            int maxCol = rowBasedMax.get(row);
            int minRow = colBasedMin.get(col);
            int maxRow = colBasedMax.get(col);
            if (row>minRow && row<maxRow && col>minCol && col<maxCol)
            {
                counter++;
            }
        }
        return counter;
    }
}