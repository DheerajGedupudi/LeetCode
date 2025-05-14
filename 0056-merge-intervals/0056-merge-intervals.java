class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
        LinkedList<int[]> list = new LinkedList<>();
        int n = intervals.length;
        list.addLast(intervals[0]);
        for (int i=1; i<n; i++)
        {
            int[] last = list.getLast();
            if (last[1]>=intervals[i][0])
            {
                int min = Math.min(intervals[i][0], last[0]);
                int max = Math.max(intervals[i][1], last[1]);
                list.removeLast();
                list.addLast(new int[]{min, max});
            }
            else
            {
                list.addLast(intervals[i]);
            }
        }
        int size = list.size();
        int[][] answer = new int[size][2];
        for (int i=0; i<size; i++)
        {
            answer[i] = list.getFirst();
            list.removeFirst();
        }
        return answer;
    }
}