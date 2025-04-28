class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : stones)
        {
            heap.offer(x);
        }
        while(heap.size()>1)
        {
            int x = heap.poll();
            int y = heap.poll();
            if (x>y)
            {
                heap.offer(x-y);
            }
        }
        if (heap.isEmpty())
        {
            return 0;
        }
        else
        {
            return heap.poll();
        }
    }
}