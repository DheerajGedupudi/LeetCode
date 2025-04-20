class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict)
        {
            trie.add(word);
        }
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int end=0; end<n; end++)
        {
            for (int start=0; start<=end; start++)
            {
                if ( (start==0 || dp[start-1]) && trie.contains(s, start, end))
                {
                    dp[end] = true;
                }
            }
        }
        return dp[n-1];
    }
}

class Trie
{
    TrieNode root;

    Trie()
    {
        this.root = new TrieNode();
    }

    void add(String s)
    {
        TrieNode curr = this.root;
        for (char c : s.toCharArray())
        {
            int index = c-'a';
            if (curr.children[index]==null)
            {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.flag = true;
    }

    boolean contains(String s, int start, int end)
    {
        TrieNode curr = this.root;
        for (int i=start; i<=end; i++)
        {
            int index = s.charAt(i)-'a';
            if (curr.children[index]==null)
            {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.flag;
    }
}

class TrieNode
{
    TrieNode[] children;
    boolean flag;

    TrieNode()
    {
        this.children = new TrieNode[26];
        this.flag = false;
    }   
}