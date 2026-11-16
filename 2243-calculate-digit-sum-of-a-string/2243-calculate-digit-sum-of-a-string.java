class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k)
        {
            int len = s.length();
            int times = len/k;
            StringBuilder sb = new StringBuilder();
            for (int t=0; t<=times; t++)
            {
                int offset = t*k;
                int end = Math.min(offset+k, len);
                if (offset<end)
                {
                    sb.append(get(s.substring(offset, end)));
                }
            }
            s = sb.toString();
        }
        return s;
    }

    private int get(String s)
    {
        int sum = 0;
        for (int i=0; i<s.length(); i++)
        {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}