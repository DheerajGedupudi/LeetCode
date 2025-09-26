class Solution {
    public int kthFactor(int n, int k) {
        boolean hasAtleastK = false;
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=1; i*i<=n; i++)
        {
            if (n%i==0)
            {
                heap.offer(i);
                if (heap.size()==k)
                {
                    hasAtleastK = true;
                }
                if (heap.size()>k)
                {
                    heap.poll();
                }
                if (n/i!=i)
                {
                    heap.offer(n/i);
                    if (heap.size()==k)
                    {
                        hasAtleastK = true;
                    }
                    if (heap.size()>k)
                    {
                        heap.poll();
                    }
                }
            }
        }
        if (hasAtleastK==false)
        {
            return -1;
        }
        return heap.peek();
    }
}