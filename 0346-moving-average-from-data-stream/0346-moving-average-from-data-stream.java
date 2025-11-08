class MovingAverage {

    private Queue<Integer> q;
    private int size;
    private double sum;

    public MovingAverage(int size) {
        this.q = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }
    
    public double next(int val) {
        q.offer(val);
        this.sum += val;
        if (q.size()>this.size)
        {
            this.sum -= q.poll();
        }
        return this.sum/q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */