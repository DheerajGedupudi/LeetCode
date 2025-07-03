class KthLargest {

    private Queue<Integer> minHeap;
    private int k1;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k1 = k;
        for (int x : nums)
        {
            this.minHeap.offer(x);
            if (this.minHeap.size()>k)
            {
                this.minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        this.minHeap.offer(val);
        if (this.minHeap.size()>k1)
        {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */