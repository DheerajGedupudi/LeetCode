class Solution {

    private Map<Integer, Integer> memo;

    public int numDecodings(String s) {
        this.memo = new HashMap<>();
        return helper(s, 0);
    }

    private int helper(String s, int index)
    {
        if (this.memo.containsKey(index))
        {
            return this.memo.get(index);
        }
        int len = s.length();
        if (index==len)
        {
            return 1;
        }
        int x = Character.getNumericValue(s.charAt(index));
        int answer = 0;
        if (x>0)
        {
            answer += helper(s, index+1);
            if (index<len-1)
            {
                int y = Character.getNumericValue(s.charAt(index+1));
                x *= 10;
                x += y;
                if (x>=1 && x<=26)
                {
                    answer += helper(s, index+2);
                }
            }
        }
        this.memo.put(index, answer);
        return answer;
    }
}