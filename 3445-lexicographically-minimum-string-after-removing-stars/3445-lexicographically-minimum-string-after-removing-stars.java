class Solution {
    public String clearStars(String s) {
        TreeMap<Character, List<Integer>> freqMap = new TreeMap<>();
        StringBuilder sb = new StringBuilder(s);
        for (int i=0; i<sb.length(); i++)
        {
            char c = sb.charAt(i);
            if (c=='*')
            {
                //getSmallest
                char toRemove = freqMap.firstKey();
                List<Integer> indexes = freqMap.get(toRemove);
                int last = indexes.get(indexes.size()-1);
                sb.setCharAt(last, '_');
                indexes.remove(indexes.size()-1);
                if (indexes.size()==0)
                {
                    freqMap.remove(toRemove);
                }
            }
            else if (c!='_')
            {
                freqMap.putIfAbsent(c, new ArrayList<>());
                freqMap.get(c).add(i);
            }
        }
        for (int i=0; i<sb.length();)
        {
            char c = sb.charAt(i);
            if (c=='*'||c=='_')
            {
                sb.deleteCharAt(i);
            }
            else
            {
                i++;
            }
        }
        return sb.toString();
    }
}