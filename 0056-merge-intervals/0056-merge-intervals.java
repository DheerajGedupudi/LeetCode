class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]));
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        list.add(intervals[0]);
        for (int i=1; i<n; i++)
        {
            int[] last = list.get(list.size()-1);
            if (last[1]>=intervals[i][0])
            {
                int min = Math.min(intervals[i][0], last[0]);
                int max = Math.max(intervals[i][1], last[1]);
                list.remove(list.size()-1);
                list.add(new int[]{min, max});
            }
            else
            {
                list.add(intervals[i]);
            }
        }
        int size = list.size();
        int[][] answer = new int[size][2];
        for (int i=0; i<size; i++)
        {
            answer[i] = list.get(i);
        }
        return answer;
    }
}