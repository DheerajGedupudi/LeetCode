class Solution {
    public int calculate(String s) {
        int len = s.length();
        Deque<String> stack = new ArrayDeque<>();
        boolean pos = true;
        int currNum = 0;
        for (int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            if (Character.isDigit(c))
            {
                currNum *= 10;
                currNum += Character.getNumericValue(c);
            }
            else
            {
                stack.push((pos?"+":"-")+currNum);
                currNum = 0;
                if (c=='(')
                {
                    stack.push((pos?"+":"-")+c+"");
                    pos = true;
                }
                else if (c==')')
                {
                    solve(stack);
                    // System.out.println("solved : "+stack);
                }
                else if (c=='+')
                {
                    pos = true;
                }
                else if (c=='-')
                {
                    pos = false;
                }
            }
        }
        stack.push((pos?"+":"-")+currNum);
        solve(stack);
        int result = Integer.parseInt(stack.pop());
        return result;
    }

    private void solve(Deque<String> stack)
    {
        int result = 0;
        while(stack.isEmpty()==false && stack.peek().equals("-(")==false && stack.peek().equals("+(")==false)
        {
            result += Integer.parseInt(stack.pop());
        }
        if (stack.isEmpty()==false && (stack.peek().equals("-(") || stack.peek().equals("+(")))
        {
            if (stack.pop().equals("-("))
            {
                result *= -1;
            }
        }
        stack.push(result+"");
    }
        
}