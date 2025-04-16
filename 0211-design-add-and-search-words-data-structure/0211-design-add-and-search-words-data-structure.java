class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray())
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
    
    public boolean search(String word) {
        return search(word, 0, this.root);
    }

    private boolean search(String word, int index, TrieNode curr)
    {
        if (index==word.length())
        {
            return false;
        }
        if (word.charAt(index)=='.')
        {
            for (int i=0; i<26; i++)
            {
                if (curr.children[i]!=null)
                {
                    if (index==word.length()-1 && curr.children[i].flag)
                    {
                        return true;
                    }
                    if (search(word, index+1, curr.children[i]))
                    {
                        return true;
                    }
                }
            }
        }
        else
        {
            int trieIndex = word.charAt(index)-'a';
            if (curr.children[trieIndex]!=null)
            {
                if (index==word.length()-1 && curr.children[trieIndex].flag)
                {
                    return true;
                }
                return search(word, index+1, curr.children[trieIndex]);
            }
        }
        return false;
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

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */