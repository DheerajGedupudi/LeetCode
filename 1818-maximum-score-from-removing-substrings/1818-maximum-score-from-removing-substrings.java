class Solution {
    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        int sum = 0;
        if (x>y)
        {
            sum += gainAB(sb, x);
            // System.out.println(sb+" "+sum);
            sum += gainBA(sb, y);
            // System.out.println(sb+" "+sum);
        }
        else
        {
            sum += gainBA(sb, y);
            // System.out.println(sb+" "+sum);
            sum += gainAB(sb, x);
            // System.out.println(sb+" "+sum);
        }
        return sum;

    }

    int gainAB(StringBuilder sb, int num)
    {
        Deque<Character> stack = new ArrayDeque<>();
        int sum = 0;
        String s = sb.toString();
        sb.setLength(0);
        for (char c : s.toCharArray())
        {
            if (!stack.isEmpty() && c=='b' && stack.peek()=='a')
            {
                stack.pop();
                sum += num;
            }
            else
            {
                stack.push(c);
            }
        }
        while(stack.isEmpty()==false)
        {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sum;
    }

    int gainBA(StringBuilder sb, int num)
    {
        Deque<Character> stack = new ArrayDeque<>();
        int sum = 0;
        String s = sb.toString();
        sb.setLength(0);
        for (char c : s.toCharArray())
        {
            if (!stack.isEmpty() && c=='a' && stack.peek()=='b')
            {
                stack.pop();
                sum += num;
            }
            else
            {
                stack.push(c);
            }
        }
        while(stack.isEmpty()==false)
        {
            sb.append(stack.pop());
        }
        sb.reverse();
        return sum;
    }
}