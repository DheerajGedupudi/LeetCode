class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals)
        {
            if (list.isEmpty())
            {
                list.add(interval);
                continue;
            }
            //if overlap, merge
            int[] last = list.get(list.size()-1);
            int maxStart = Math.max(interval[0], last[0]);
            int minEnd = Math.min(interval[1], last[1]);
            if (minEnd-maxStart>=0)
            {
                list.remove(list.size()-1);
                int minStart = Math.min(interval[0], last[0]);
                int maxEnd = Math.max(interval[1], last[1]);
                list.add(new int[]{minStart, maxEnd});
            }
            else
            {
                list.add(interval);
            }
        }
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] interval : list)
        {
            result[index++] = interval;
        }
        return result;
    }
}