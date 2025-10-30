class Solution {

    private List<String> result;

    public List<String> generatePalindromes(String s) {
        this.result = new ArrayList<>();
        int[] count = new int[26];
        for (char c : s.toCharArray())
        {
            count[c-'a']++;
        }
        Character odd = null;
        for (int i=0; i<26; i++)
        {
            if (count[i]%2==1)
            {
                if (odd==null)
                {
                    odd = (char)(i+'a');
                }
                else
                {
                    return this.result;
                }
            }
            //only consider half
            count[i] /= 2;
        }
        int length = 0;
        for (int i=0; i<26; i++)
        {
            length += count[i];
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