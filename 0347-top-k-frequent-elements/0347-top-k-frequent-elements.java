class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int cap = ((int)Math.pow(10,4)*2)+2;
        int offset = (int)Math.pow(10,4);
        int[] hash = new int[cap];
        for (int x : nums)
        {
            hash[x+offset]++;
        }
        Queue<Integer> heap = new PriorityQueue<>((a,b)->(hash[a]-hash[b]));
        for (int i=0; i<cap; i++)
        {
            if (hash[i]>0)
            {
                heap.offer(i);
            }
            if (heap.size()>k)
            {
                heap.poll();
            }
        }
        int resultSize = Math.max(k, heap.size());
        int[] result = new int[resultSize];
        for (int i=0; i<resultSize; i++)
        {
            int hashIndex = heap.poll();
            result[i] = hashIndex-offset;
        }
        return result;
    }
}