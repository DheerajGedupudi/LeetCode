class Solution {
    public char kthCharacter(int k) {
        String s = "a";
        while(s.length()<k)
        {
            s = next(s);
        }
        return s.charAt(k-1);
    }

    private String next(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();
        for (int i=0; i<len; i++)
        {
            char c = s.charAt(i);
            sb.append(next(c));
        }
        return sb.toString();
    }

    private char next(char c)
    {
        int x = (int)c-'a';
        x++;
        x %= 26;
        return (char)(x+'a');
    }
}