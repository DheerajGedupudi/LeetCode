class Solution {
    public boolean hasSameDigits(String s) {
        Queue<Integer> q = new ArrayDeque<>();
        for (char c : s.toCharArray())
        {
            int x = Character.getNumericValue(c);
            q.offer(x);
        }
        // System.out.println(q);
        while(q.size()>2)
        {
            Queue<Integer> q2 = new ArrayDeque<>();
            int last = q.poll();
            while(q.isEmpty()==false)
            {
                int curr = q.poll();
                int sum = (last+curr)%10;
                last = curr;
                q2.offer(sum);
            }
            while(q.isEmpty()==false)
            {
                q2.offer(q.poll());
            }
            q = q2;
            // System.out.println(q);

        }
        int last1 = q.poll();
        int last2 = q.poll();
        return last1==last2;
    }
}