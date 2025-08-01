class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        result.add(row);
        for (int i=1; i<numRows; i++)
        {
            List<Integer> row2 = new ArrayList<>();
            row2.add(1);
            for (int j=1; j<row.size(); j++)
            {
                row2.add(row.get(j-1)+row.get(j));
            }
            row2.add(1);
            result.add(row2);
            row = new ArrayList<>(row2);
        }
        return result;
    }
}