class Solution {

    private boolean[] memo;

    public int longestValidParentheses(String s) {
        int n = s.length();
        this.memo = new boolean[n];
        for (int i=0; i+1<n; i++)
        {
            helper(s, i, i+1);
        }
        int max = 0;
        int count = 0;
        for (int i=0; i<n; i++)
        {
            if (this.memo[i])
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

    private void helper(String s, int start, int end)
    {
        int n = s.length();
        if (start<0 || end>=n)
        {
            return;
        }
        if ((end-start)%2==0) //odd
        {
            return;
        }
        if (s.charAt(start)=='(' && s.charAt(end)==')')
        {
            this.memo[start] = true;
            this.memo[end] = true;
            helper(s, start-1, end+1);
            return;
        }
        boolean flag = false;
        while(start>=0 && this.memo[start])
        {
            flag = true;
            start--;
        }
        while(end<n && this.memo[end])
        {
            flag = true;
            end++;
        }
        if (flag)
        {
            //expanded search
            helper(s, start, end);
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