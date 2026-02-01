class Solution {
    public int minimumCost(int[] nums) {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        for (int i=1; i<n; i++)
        {
            heap.offer(nums[i]);
            if (heap.size()>2)
            {
                heap.poll();
            }
        }
        int sum = nums[0];
        while(heap.isEmpty()==false)
        {
            sum += heap.poll();
        }
        return sum;
    }
}