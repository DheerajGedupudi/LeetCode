class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, ((a,b)-> (a[0]!=b[0]?(a[0]-b[0]):(a[1]-b[1]) ) ));
        // System.out.println(Arrays.deepToString(events));
        Queue<int[]> heap = new PriorityQueue<>((a,b)-> (a[1]==b[1]?(a[0]-b[0]):(a[1]-b[1]) ) );
        int n = events.length;
        int count = 0;
        int i=0;
        int current = -1;
        while(i<n || heap.isEmpty()==false)
        {
            if (i<n && heap.isEmpty())
            {
                current = events[i][0];
            }
            //add all that have started
            while(i<n && events[i][0]<=current)
            {
                heap.offer(events[i++]);
            }
            //remove those were already done
            while(heap.isEmpty()==false && current>heap.peek()[1])
            {
                heap.poll();
            }
            //at this point all in heap qualify
            if (heap.isEmpty()==false)
            {
                current = Math.max(current, heap.peek()[0]);
            }
            if (heap.isEmpty()==false && current<=heap.peek()[1])
            {
                count++;
                heap.poll();
                current++;
            }
            // System.out.println(Arrays.toString(events[i-1])+", heap : "+heap+", count : "+count);
        }
        return count;
    }
}