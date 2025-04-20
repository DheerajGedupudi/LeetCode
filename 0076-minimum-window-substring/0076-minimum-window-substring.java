class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray())
        {
            mapT.put(c, mapT.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> mapS = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int len = s.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(p2<len)
        {
            //move right till same
            while(p2<len && has(mapS, mapT)==false)
            {
                char toAdd = s.charAt(p2);
                mapS.put(toAdd, mapS.getOrDefault(toAdd, 0)+1);
                p2++;
            }
            if (has(mapS, mapT))
            {
                int len2 = p2-p1+1;
                if (len2<min)
                {
                    start = p1;
                    end = p2;
                }
                min = Math.min(min, len2);
            }
            //move left till not same
            while(p1<p2 && has(mapS, mapT))
            {
                char toRemove = s.charAt(p1);
                mapS.put(toRemove, mapS.getOrDefault(toRemove, 0)-1);
                //last left, before not valid
                if (p1<p2 && has(mapS, mapT)==false)
                {
                    int len2 = p2-p1+1;
                    if (len2<min)
                    {
                        start = p1;
                        end = p2;
                    }
                    min = Math.min(min, len2);
                }
                p1++;
            }
        }
        return s.substring(start, end);
    }

    private boolean has(Map<Character, Integer> mapS, Map<Character, Integer> mapT)
    {
        for (char c : mapT.keySet())
        {
            if (mapT.get(c)>mapS.getOrDefault(c,0))
            {
                return false;
            }
        }
        return true;
    }
}