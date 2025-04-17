class Solution {
    public int reverse(int x) {
        int MAX = Integer.MAX_VALUE;
        int maxBy10 = MAX/10;
        int lastDigitOfMax = MAX%10;
        boolean neg = false;
        if (x<0)
        {
            neg = true;
        }
        x = Math.abs(x);
        int answer = 0;
        while(x>0)
        {
            int digit = x%10;
            int diff = MAX-answer;
            if (answer>maxBy10)
            {
                return 0;
            }
            if (answer==maxBy10 && digit>lastDigitOfMax)
            System.out.println("answer : "+answer+" , billion : "+maxBy10+", digit : "+digit);
            answer *= 10;
            answer += digit;
            x /= 10;
        }
        if (neg)
        {
            return (answer)*(-1);
        }
        return answer;
    }
}