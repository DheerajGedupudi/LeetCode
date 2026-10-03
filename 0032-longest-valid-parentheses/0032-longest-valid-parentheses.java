class Solution {

    public int longestValidParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i+1<n; i++)
        {
            helper(sb, i, i+1);
        }
        // System.out.println(sb);
        // System.out.println(sb.length());
        int max = 0;
        int count = 0;
        for (int i=0; i<n; i++)
        {
            if (sb.charAt(i)=='-')
            {
                count++;
            }
            else
            {
                count = 0;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    private void helper(StringBuilder sb, int start, int end)
    {
        int n = sb.length();
        if (start<0 || end>=n)
        {
            return;
        }
        if ((end-start)%2==0) //odd
        {
            return;
        }
        if (sb.charAt(start)=='(' && sb.charAt(end)==')')
        {
            sb.setCharAt(start, '-');
            sb.setCharAt(end, '-');
            helper(sb, start-1, end+1);
            return;
        }
        boolean flag = false;
        while(start>=0 && sb.charAt(start)=='-')
        {
            flag = true;
            start--;
        }
        while(end<n && sb.charAt(end)=='-')
        {
            flag = true;
            end++;
        }
        if (flag)
        {
            //expanded search
            helper(sb, start, end);
        }
    }
}



/*

2 char: ()

4 char: ()(), (())

6 char: ((())), ()()(), (()()), ()(()), (())()

8 char: ....


opt1: (__) => ()(), (()) 

opt2:  (__( => no, )__) => no


*/