class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int p1 = 0;
        int max = 0;
        for (int p2=0; p2<n; p2++)
        {
            char c = s.charAt(p2);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.get(c)>1)
            {
                char d = s.charAt(p1);
                map.put(d, map.getOrDefault(d, 0)-1);
                p1++;
            }
            max = Math.max(max, p2-p1+1);
        }
        return max;
        
    }
}