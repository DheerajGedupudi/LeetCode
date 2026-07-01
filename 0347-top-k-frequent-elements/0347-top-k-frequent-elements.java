class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int cap = ((int)Math.pow(10,4)*2)+2;
        int offset = (int)Math.pow(10,4);
        int[] hash = new int[cap];
        for (int x : nums)
        {
            hash[x+offset]++;
        }
        Queue<Node> heap = new PriorityQueue<>((a,b)->(a.freq-b.freq));
        for (int i=0; i<cap; i++)
        {
            if (hash[i]>0)
            {
                heap.offer(new Node(i-offset, hash[i]));
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
            result[i] = heap.poll().number;
        }
        return result;
    }
}

class Node
{
    int number;
    int freq;

    Node(int number, int freq)
    {
        this.number = number;
        this.freq = freq;
    }
}