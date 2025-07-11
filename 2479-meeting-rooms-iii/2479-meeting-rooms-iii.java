class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Queue<int[]> availHeap = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        Queue<int[]> occupHeap = new PriorityQueue<>((a,b)->(a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]));
        Arrays.sort(meetings, (a,b)->(a[0]-b[0]));
        for (int i=0; i<n; i++)
        {
            availHeap.offer(new int[]{i, 0});
        }
        for (int[] meet : meetings)
        {
            //free up rooms that are available
            while(occupHeap.isEmpty()==false && occupHeap.peek()[1]<=meet[0])
            {
                availHeap.offer(occupHeap.poll());
            }
            //if still no available room, then jump in time to next available room
            if (availHeap.isEmpty())
            {
                int[] earliestAvailRoom = occupHeap.poll();
                int startTime = Math.max(earliestAvailRoom[1], meet[0]);
                earliestAvailRoom[1] = meet[1]-meet[0]+startTime;
                occupHeap.offer(earliestAvailRoom);
                count[earliestAvailRoom[0]]++;
            }
            //room available
            else
            {
                int[] room = availHeap.poll();
                int startTime = Math.max(room[1], meet[0]);
                room[1] = meet[1]-meet[0]+startTime;
                occupHeap.offer(room);
                count[room[0]]++;
            }
        }
        int max = 0;
        int ans = -1;
        for (int i=0; i<n; i++)
        {
            if (count[i]>max)
            {
                max = count[i];
                ans = i;
            }
        }
        return ans;
    }
}