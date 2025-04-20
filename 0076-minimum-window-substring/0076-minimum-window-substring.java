class Solution {
    public String minWindow(String s, String t) {
        Count sCount = new Count();
        Count tCount = new Count();
        for (char c : t.toCharArray())
        {
            tCount.add(c);
        }
        int p1 = 0;
        int p2 = 0;
        int len = s.length();
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while(p2<len)
        {
            //move right till same
            while(p2<len && sCount.has(tCount)==false)
            {
                char toAdd = s.charAt(p2);
                sCount.add(toAdd);
                p2++;
            }
            if (sCount.has(tCount))
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
            while(p1<p2 && sCount.has(tCount))
            {
                char toRemove = s.charAt(p1);
                sCount.delete(toRemove);
                //last left, before not valid
                if (p1<p2 && sCount.has(tCount)==false)
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
}

class Count
{
    int[] lowerCaseCount;
    int[] upperCaseCount;

    Count()
    {
        this.lowerCaseCount = new int[26];
        this.upperCaseCount = new int[26];
    }

    void add(char c)
    {
        int x = c-'a';
        if (x>=0 && x<26)
        {
            lowerCaseCount[x]++;
        }
        else
        {
            upperCaseCount[c-'A']++;
        }
    }

    void delete(char c)
    {
        int x = c-'a';
        if (x>=0 && x<26)
        {
            lowerCaseCount[x]--;
        }
        else
        {
            upperCaseCount[c-'A']--;
        }
    }

    boolean has(Count count2)
    {
        for (int i=0; i<26; i++)
        {
            if (this.lowerCaseCount[i]<count2.lowerCaseCount[i])
            {
                return false;
            }
        }
        for (int i=0; i<26; i++)
        {
            if (this.upperCaseCount[i]<count2.upperCaseCount[i])
            {
                return false;
            }
        }
        return true;
    }

}