class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        // System.out.println(Arrays.deepToString(intervals));
        int maxEnd = -1;
        int count = 0;
        for (int[] interval : intervals)
        {
            if (interval[1]>maxEnd)
            {
                count++;
            }
            maxEnd = Math.max(maxEnd, interval[1]);
        }
        return count;
    }
}