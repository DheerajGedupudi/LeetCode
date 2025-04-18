class Solution {
    public String countAndSay(int n) {
        StringBuilder num = new StringBuilder("1");
        while(n>1)
        {
            StringBuilder sb = new StringBuilder();
            Character last = null;
            int count = 0;
            int len = num.length();
            for (int i=0; i<len; i++)
            {
                char c = num.charAt(i);
                if (last==null)
                {
                    last = c;
                    count = 1;
                    continue;
                }
                if (c!=last)
                {
                    sb.append(count);
                    sb.append(last);
                    count = 1;
                }
                else
                {
                    count++;
                }
                last = c;
            }
            sb.append(count);
            sb.append(last);
            num = sb;
            n--;
        }
        return num.toString();
    }
}