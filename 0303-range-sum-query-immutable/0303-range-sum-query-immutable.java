class NumArray {

    private int[] prefix;

    public NumArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        this.prefix = new int[n+1];
        for (int i=0; i<n; i++)
        {
            sum += nums[i];
            prefix[i+1] = sum;
        }
    }
    
    public int sumRange(int left, int right) {
        return this.prefix[right+1]-this.prefix[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */