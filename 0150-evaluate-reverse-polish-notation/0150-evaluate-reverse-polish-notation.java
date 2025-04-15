class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens)
        {
            //operand
            if (token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/"))
            {
                String top1 = stack.pop();
                String top2 = stack.pop();
                //if -, then top2-top1, not top1-top2
                int first = Integer.parseInt(top2);
                int second = Integer.parseInt(top1);
                int result = 0;
                if (token.equals("+"))
                {
                    result = first+second;
                }
                else if (token.equals("-"))
                {
                    result = first-second;
                }
                else if (token.equals("*"))
                {
                    result = first*second;
                }
                else if (token.equals("/"))
                {
                    result = first/second;
                }
                stack.push(Integer.toString(result));
            }
            else
            {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}