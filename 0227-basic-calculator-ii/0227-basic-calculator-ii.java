class Solution {
    public int calculate(String s) {
        Deque<Integer> q1 = new LinkedList<>();
        Deque<Character> q2 = new LinkedList<>();
        Integer num = null;
        for (char c : s.toCharArray())
        {
            if (c==' ')
            {
                continue;
            }
            if (Character.isDigit(c))
            {
                if (num==null)
                {
                    num = 0;
                }
                num *= 10;
                num += Character.getNumericValue(c);
            }
            else
            {
                if (num!=null)
                {
                    q1.offer(num);
                }
                num = null;
                q2.offer(c);
            }
        }
        if (num!=null)
        {
            q1.offer(num);
        }
        // System.out.println(q1);
        // System.out.println(q2);
        //div and mul
        Queue<Integer> q11 = new LinkedList<>();
        Queue<Character> q22 = new LinkedList<>();
        while(q1.size()>1)
        {
            int op1 = q1.poll();
            char sym = q2.poll();
            int op2 = q1.poll();
            if (sym=='/')
            {
                int x = op1/op2;
                q1.offerFirst(x);
            }
            else if (sym=='*')
            {
                int x = op1*op2;
                q1.offerFirst(x);
            }
            else
            {
                q11.offer(op1);
                q22.offer(sym);
                q1.offerFirst(op2);
            }
        }
        q11.offer(q1.poll());
        //now add and sub
        int result = q11.poll();
        while(q11.isEmpty()==false)
        {
            char sym = q22.poll();
            int x = q11.poll();
            if (sym=='+')
            {
                result += x;
            }
            else
            {
                result -= x;
            }
        }
        return result;
    }
}