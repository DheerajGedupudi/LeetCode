class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> colMap = new HashMap<>();
        for (int[] b : buildings)
        {
            rowMap.putIfAbsent(b[0], new TreeSet<>());
            rowMap.get(b[0]).add(b[1]);
            colMap.putIfAbsent(b[1], new TreeSet<>());
            colMap.get(b[1]).add(b[0]);
        }
        int count = 0;
        for (int[] b : buildings)
        {
            int colMin = rowMap.get(b[0]).first();
            int colMax = rowMap.get(b[0]).last();
            int rowMin = colMap.get(b[1]).first();
            int rowMax = colMap.get(b[1]).last();
            if (b[0]>rowMin && b[0]<rowMax && b[1]>colMin && b[1]<colMax)
            {
                count++;
            }
        }
        return count;
    }
}