class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a,b)->(a[0]!=b[0])?(a[0]-b[0]):b[1]-a[1]);
        Queue<Node> heap = new PriorityQueue<>((a,b)->(a.intervalSize==b.intervalSize)?(a.intervalEnd-b.intervalEnd):a.intervalSize-b.intervalSize);
        int[] sortedQ = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQ);
        Map<Integer, Integer> queryAnswers = new HashMap<>();
        int index = 0;
        for (int q : sortedQ)
        {
            while(index<intervals.length && intervals[index][0]<=q)
            {
                heap.offer(new Node(intervals[index][0], intervals[index][1]));
                index++;
            }
            while(heap.isEmpty()==false && heap.peek().intervalEnd<q)
            {
                heap.poll();
            }
            queryAnswers.put(q, heap.isEmpty()?-1:heap.peek().intervalSize);
        }
        int m = queries.length;
        int[] answers = new int[m];
        for (int i=0; i<m; i++)
        {
            answers[i] = queryAnswers.get(queries[i]);
        }
        return answers;
    }
}

class Node
{
    int intervalSize;
    int intervalEnd;

    Node (int start, int end)
    {
        this.intervalSize = end-start+1;
        this.intervalEnd = end;
    }
}