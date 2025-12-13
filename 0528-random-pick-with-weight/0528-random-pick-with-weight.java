class Solution {

    private Random random;
    private int[] prefix;
    private int sum;

    public Solution(int[] w) {
        int n = w.length;
        this.prefix = new int[n];
        this.sum = 0;
        this.random = new Random();
        for (int i=0; i<n; i++)
        {
            this.sum += w[i];
            this.prefix[i] = this.sum;
        }
    }
    
    public int pickIndex() {
        int random = getRandomIndex();
        return floor(random);
    }

    private int floor(int target)
    {
        int n = this.prefix.length;
        int low = 0;
        int high = n-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (this.prefix[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                best = mid;
                high = mid-1;
            }
        }
        return best;
    }

    private int getRandomIndex()
    {
        return this.random.nextInt(this.sum)+1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */