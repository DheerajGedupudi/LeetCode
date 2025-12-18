class Solution {

    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new Boolean[s.length()+1];
        return helper(s, wordDict, 0);
    }

    private boolean helper(String s, List<String> wordDict, int index)
    {
        if (this.memo[index]!=null)
        {
            return this.memo[index];
        }
        int len = s.length();
        if (index==len)
        {
            this.memo[index] = true;
            return true;
        }
        for (String word : wordDict)
        {
            if (check(s, word, index))
            {
                // System.out.println("possible : "+s.substring(index)+" used : "+word);
                if (helper(s, wordDict, index+word.length()))
                {
                    this.memo[index] = true;
                    return true;
                }
            }
        }
        this.memo[index] = false;
        return false;
    }

    private boolean check(String s, String word, int index)
    {
        int len = s.length();
        int len2 = index+word.length();
        if (len2<=len)
        {
            for (int i=0; i<word.length(); i++)
            {
                if (s.charAt(i+index)!=word.charAt(i))
                {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

/*

 catsandog
       dog

*/