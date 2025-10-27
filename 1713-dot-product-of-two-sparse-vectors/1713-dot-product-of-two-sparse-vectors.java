class SparseVector {

    private int[] nums;
    
    SparseVector(int[] nums) {
        this.nums = nums;
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int sum = 0;
        int n = this.nums.length;
        for (int i=0; i<n; i++)
        {
            if (this.nums[i]!=0 && vec.nums[i]!=0)
            {
                sum += (this.nums[i]*vec.nums[i]);
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);