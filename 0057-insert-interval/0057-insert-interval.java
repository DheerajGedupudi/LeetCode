class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int insertStart = newInterval[0];
        int insertEnd = newInterval[1];
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        int i=0;
        for (i=0; i<n; i++)
        {
            int[] curr = intervals[i];
            //before
            if (curr[1]<newInterval[0])
            {
                list.add(curr);
            }
            //to be merged
            if (isOverlap(curr, newInterval))
            {
                insertStart = Math.min(insertStart, curr[0]);
                insertEnd = Math.max(insertEnd, curr[1]);
            }
            //after
            if (curr[0]>newInterval[1])
            {
                break;
            }
        }
        list.add(new int[]{insertStart, insertEnd});
        while(i<n)
        {
            list.add(intervals[i++]);
        }
        int size = list.size();
        int[][] result = new int[size][2];
        for (i=0; i<size; i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isOverlap(int[] interval, int[] newInterval)
    {
        if (interval[1]<newInterval[0] || interval[0]>newInterval[1])
        {
            return false;
        }
        return true;
    }
}