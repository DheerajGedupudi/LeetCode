class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            map.put(c, i);
        }
        int last = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            count++;
            last = Math.max(last, map.get(c));
            if (last==i)
            {
                result.add(count);
                count = 0;
            }
        }
        return result;
    }
}