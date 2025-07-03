class Solution {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String answer = "";
        int n = s.length();
        for (int i=0; i<n; i++)
        {
            String s1 = check(s, i, i);
            if (s1.length()>maxLength)
            {
                maxLength = s1.length();
                answer = s1;
            }
            String s2 = check(s, i, i+1);
            if (s2.length()>maxLength)
            {
                maxLength = s2.length();
                answer = s2;
            }
        }
        return answer;
    }

    private String check(String s, int start, int end)
    {
        int n = s.length();
        while(start>=0 && end<n && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return s.substring(start+1,end);
    }
}