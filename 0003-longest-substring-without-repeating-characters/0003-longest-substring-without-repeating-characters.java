class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();
        int n = s.length();
        int max = 0;
        int p1 = 0;
        for (int p2=0; p2<n; p2++)
        {
            char c = s.charAt(p2);
            Integer last = lastIndex.get(c);
            if (last!=null)
            {
                if (last>=p1)
                {
                    p1 = last+1;
                }
            }
            max = Math.max(max, p2-p1+1);
            lastIndex.put(c, p2);
        }
        return max;
        
    }
}