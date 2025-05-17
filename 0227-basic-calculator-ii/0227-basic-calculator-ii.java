class Solution {
    public int calculate(String s) {
        int len = s.length();
        int currNum = 0;
        char sign = '+';
        Deque<String> stack = new ArrayDeque<>();
        for (int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            if (c==' ')
            {
                continue;
            }
            //is num
            if (Character.isDigit(c))
            {
                currNum *= 10;
                currNum += Character.getNumericValue(c);
            }
            else if (c=='+'||c=='-'||c=='*'||c=='/')
            {
                //solve mult, and div
                if (sign=='*'||sign=='/')
                {
                    int result = 0;
                    int lastNum = Integer.parseInt(stack.pop());
                    if (sign=='*')
                    {
                        result = lastNum*currNum;
                    }
                    else
                    {
                        result = lastNum/currNum;
                    }
                    stack.push(""+result);
                }
                else 
                {
                    stack.push(sign+""+currNum);
                }
                currNum = 0;
                sign = c;
            }
        }
        if (sign=='*'||sign=='/')
        {
            int result = 0;
            int lastNum = Integer.parseInt(stack.pop());
            if (sign=='*')
            {
                result = lastNum*currNum;
            }
            else
            {
                result = lastNum/currNum;
            }
            stack.push(""+result);
        }
        else
        {
            stack.push(sign+""+currNum);
        }
        int result = 0;
        while(stack.isEmpty()==false)
        {
            result += Integer.parseInt(stack.pop());
        }
        return result;
    }
}