class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray())
        {
            if (c=='(' || c=='[' || c=='{')
            {
                stack.push(c);
            }
            else if (c==')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                if (stack.peek()=='(')
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else if (c==']')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                if (stack.peek()=='[')
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
            else if (c=='}')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                if (stack.peek()=='{')
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}