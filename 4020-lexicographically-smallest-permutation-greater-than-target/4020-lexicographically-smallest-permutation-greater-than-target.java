class Solution {

    private String result;

    public String lexGreaterPermutation(String s, String target) {
        int len = target.length();
        Letters letters = new Letters();
        for (char c : s.toCharArray())
        {
            letters.add(c);
        }
        boolean flag = false;
        int i=0;
        StringBuilder sb = new StringBuilder();
        this.result = "";
        dfs(letters, target, 0, sb);
        return this.result;
    }

    boolean dfs(Letters letters, String target, int index, StringBuilder sb)
    {
        int len = target.length();
        if (index==len)
        {
            String word = sb.toString();
            if (word.compareTo(target)>0)
            {
                this.result = word;
                return true;
            }
            else
            {
                return false;
            }
        }
        char c = target.charAt(index);
        int x = c-'a';
        int start = x;
        String word = sb.toString();
        String prefix = target.substring(0, word.length());
        if (word.compareTo(prefix)>0)
        {
            start = 0;
        }
        for (int i=start; i<26; i++)
        {
            char d = (char)(i+'a');
            if (letters.has(d))
            {
                sb.append(d);
                letters.cut(d);
                if (dfs(letters, target, index+1, sb))
                {
                    return true;
                }
                sb.deleteCharAt(sb.length()-1);
                letters.add(d);
            }
        }
        return false;
    }
}


class Letters
{
    private int[] count;

    Letters()
    {
        this.count = new int[26];
    }

    char getNext(char c)
    {
        int x = c-'a';
        for (int i=x; i<26; i++)
        {
            if (this.count[i]>0)
            {
                return (char)(i+'a');
            }
        }
        return '_';
    }

    boolean has(char c)
    {
        return this.count[c-'a']>0;
    }

    void cut(char c)
    {
        // System.out.println("cutting : "+c+" , remain : "+Arrays.toString(this.count));
        int x = c-'a';
        this.count[x]--;
    }

    void add(char c)
    {
        int x = c-'a';
        this.count[x]++;
    }

    int[] getSet()
    {
        return this.count;
    }
}


/*


leet

let

->
eelt

code
eelt

baba
->
abbb

bbaa
bbab





*/