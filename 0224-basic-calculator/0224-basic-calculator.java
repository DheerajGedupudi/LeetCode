class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
        {
            if (c!=' ')
            {
                sb.append(c);
            }
        }
        s = sb.toString();
        int len = s.length();
        int num = 0;
        Deque<String> q = new ArrayDeque<>();
        for (char c : s.toCharArray())
        {
            if (Character.isDigit(c))
            {
                num *= 10;
                num += Character.getNumericValue(c);
            }
            else
            {
                if (num!=0)
                {
                    q.offerLast(Integer.toString(num));
                }
                num = 0;
                q.offerLast(c+"");
            }
        }
        if (num!=0)
        {
            q.offerLast(Integer.toString(num));
        }
        solve(q, true);
        return Integer.parseInt(q.poll());
    }

    private void solve(Deque<String> q, boolean mainSign)
    {
        // System.out.println(q);
        int sum = 0;
        boolean pos = true;
        while(q.isEmpty()==false)
        {
            String top = q.pollFirst();
            if (top.equals("("))
            {
                solve(q, pos);
            }
            else if (top.equals(")"))
            {
                if (mainSign)
                {
                    q.offerFirst(Integer.toString(sum));
                }
                else
                {
                    q.offerFirst(Integer.toString(sum));
                }
                return;
            }
            else if (top.equals("+"))
            {
                pos = true;
            }
            else if (top.equals("-"))
            {
                pos = false;
            }
            else
            {
                if (pos)
                {
                    sum += Integer.parseInt(top);
                }
                else
                {
                    sum -= Integer.parseInt(top);
                }
            }
        }
        if (mainSign)
        {
            q.offerFirst(Integer.toString(sum));
        }
        else
        {
            q.offerFirst(Integer.toString(-1*sum));
        }
    }
}