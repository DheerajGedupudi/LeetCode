class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        //option 1, replace, same length
        if (lens==lent)
        {
            int count = 0;
            for (int i=0; i<lens; i++)
            {
                if (s.charAt(i)!=t.charAt(i))
                {
                    count++;
                }
            }
            return count==1;
        }
        //option 2, s is bigger by 1
        if (lens==lent+1)
        {
            return needsOneInsert(s, t);
        }
        //option 3, reverse case of option 2
        if (lens+1==lent)
        {
            return needsOneInsert(t, s);
        }
        return false;
    }

    private boolean needsOneInsert(String s, String t)
    {
        //s is bigger by 1
        int lens = s.length();
        int lent = t.length();
        int i=0;
        int j=0;
        int count = 0;
        while(i<lens && j<lent)
        {
            // System.out.println("now checking : "+s.charAt(i)+", "+t.charAt(j));
            if (i<lens && j<lent && s.charAt(i)!=t.charAt(j))
            {
                // System.out.println("skipping : "+s.charAt(i)+", "+t.charAt(j));
                count++;
                i++;
            }
            else
            {
                i++;
                j++;
            }
        }
        //not last, then last is inserted
        if (i==lens-1 && j==lent && count==0)
        {
            return true;
        }
        return i==lens && j==lent && count==1;
    }
}