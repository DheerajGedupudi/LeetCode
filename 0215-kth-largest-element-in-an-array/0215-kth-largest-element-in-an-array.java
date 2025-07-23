class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums)
        {
            minHeap.offer(x);
            if (minHeap.size()>k)
            {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}