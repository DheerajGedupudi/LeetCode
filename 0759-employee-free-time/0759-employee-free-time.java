/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        Queue<Queue<Interval>> heap = new PriorityQueue<>(
            (a, b)->(a.peek().start!=b.peek().start?a.peek().start-b.peek().start:b.peek().end-a.peek().end)
        );
        int n = schedule.size();
        for (int i=0; i<n; i++)
        {
            Queue<Interval> q = new LinkedList<>(schedule.get(i));
            heap.offer(q);
        }
        List<Interval> result = new ArrayList<>();
        int lastEnd = heap.peek().peek().end;
        while(heap.isEmpty()==false)
        {
            Queue<Interval> curr = heap.poll();
            Interval in = curr.poll();
            // System.out.println(in.start+" "+in.end);
            // overlap
            if (in.start>lastEnd)
            {
                Interval in2 = new Interval(lastEnd, in.start);
                result.add(in2);
            }
            //no overlap
            lastEnd = Math.max(lastEnd, in.end);
            if (curr.isEmpty()==false)
            {
                heap.offer(curr);
            }
        }
        return result;

    }
}