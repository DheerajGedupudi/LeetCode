class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) 
    {
        Map<Character, TreeSet<Character>> map = new HashMap<>();
        int len = s1.length();
        for (int i=0; i<len; i++)
        {
            char c = s1.charAt(i);
            char d = s2.charAt(i);
            TreeSet<Character> set1 = map.getOrDefault(c, new TreeSet<>());
            set1.add(d);
            map.put(c, set1);
            TreeSet<Character> set2 = map.getOrDefault(d, new TreeSet<>());
            set2.add(c);
            map.put(d, set2);
        }
        for (char c : map.keySet())
        {
            TreeSet<Character> set = map.get(c);
            for (char d : set)
            {
                map.get(d).addAll(set);
            }
        }
        // System.out.println(map);
        StringBuilder sb = new StringBuilder();
        int n = baseStr.length();
        for (int i=0; i<n; i++)
        {
            char c = baseStr.charAt(i);
            if (map.containsKey(c))
            {
                c = map.get(c).first();
            }
            sb.append(c);
        }
        return sb.toString();
    }
}