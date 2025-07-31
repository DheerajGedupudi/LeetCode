class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0]?a[0]-b[0]:b[1]-a[1]));
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals)
        {
            if (list.size()==0)
            {
                list.add(interval);
                continue;
            }
            int[] last = list.get(list.size()-1);
            if (isOverlap(last, interval))
            {
                int end = Math.max(last[1], interval[1]);
                last[1] = end;
            }
            else
            {
                list.add(interval);
            }

        }
        int[][] result = new int[list.size()][2];
        for (int i=0; i<list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    private boolean isOverlap(int[] a, int[] b)
    {
        //a start <= b start
        if (b[0]<=a[1])
        {
            return true;
        }
        return false;
    }
}