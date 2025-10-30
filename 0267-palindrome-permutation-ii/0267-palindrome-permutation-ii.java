class Solution {

    private List<String> result;

    public List<String> generatePalindromes(String s) {
        this.result = new ArrayList<>();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray())
        {
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        Set<Character> oddSet = new HashSet<>();
        for (char c : freqMap.keySet())
        {
            if (freqMap.get(c)%2==1)
            {
                oddSet.add(c);
            }
        }
        if (oddSet.size()>1)
        {
            return this.result;
        }
        Character odd = null;
        if (oddSet.size()>0)
        {
            for (char c : oddSet)
            {
                odd = c;
            }
        }
        int[] count = new int[26];
        int length = 0;
        for (char c : freqMap.keySet())
        {
            count[c-'a'] = freqMap.get(c)/2;
            length += count[c-'a'];
        }
        helper(count, odd, new StringBuilder(), length);
        return this.result;
    }

    private void helper(int[] count, Character odd, StringBuilder sb, int targetLength)
    {
        // System.out.println(sb);
        if (sb.length()==targetLength)
        {
            StringBuilder sb2 = new StringBuilder(sb);
            sb2.reverse();
            String rev = sb2.toString();
            if (odd!=null)
            {
                sb.append(odd);
            }
            sb.append(rev);
            result.add(sb.toString());
            sb.setLength(targetLength);
            return;
        }
        for (int i=0; i<26; i++)
        {
            if (count[i]>0)
            {
                sb.append((char)(i+'a'));
                count[i]--;
                helper(count, odd, sb, targetLength);
                sb.deleteCharAt(sb.length()-1);
                count[i]++;
            }
        }
    }
}