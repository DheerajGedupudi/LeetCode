class Solution {
    public int maxSumDivThree(int[] nums) {
        long sum = 0;
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        for (int x : nums)
        {
            if (x%3==1)
            {
                ones.add(x);
            }
            else if (x%3==2)
            {
                twos.add(x);
            }
            sum += x;
        }
        if (sum%3==0)
        {
            return (int)sum;
        }
        long[] oneMin = getMin2(ones);
        long[] twoMin = getMin2(twos);
        // System.out.println("sum : "+sum);
        // System.out.println(Arrays.toString(oneMin));
        // System.out.println(Arrays.toString(twoMin));
        long max = 0;
        if (sum%3==1)
        {
            max = Math.max(max, sum-oneMin[0]);
            max = Math.max(max, sum-(twoMin[0]+twoMin[1]));
        }
        if (sum%3==2)
        {
            max = Math.max(max, sum-twoMin[0]);
            max = Math.max(max, sum-(oneMin[0]+oneMin[1]));
        }
        return (int)max;
    }

    private long[] getMin2(List<Integer> list)
    {
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        heap.offer(Integer.MAX_VALUE);
        heap.offer(Integer.MAX_VALUE);
        for (int x : list)
        {
            if (x<heap.peek())
            {
                heap.offer(x);
                if (heap.size()>2)
                {
                    heap.poll();
                }
            }
        }
        int min2 = heap.poll();
        int min1 = heap.poll();
        return new long[]{min1, min2}; 
    }
}

/*


. 3,6,5,1,8
3 3 6 5 1 8
6  
5
1
8



1,3,5,6,8

sum = 0 1 2

1
5 8
3 6



8,6,5,3,1
8 14 19 22 23






*/