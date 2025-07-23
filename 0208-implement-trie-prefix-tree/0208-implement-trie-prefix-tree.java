class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode curr = this.root;
        for (char c : word.toCharArray())
        {
            int index = c-'a';
            if (curr.children[index]==null)
            {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (char c : prefix.toCharArray())
        {
            int index = c-'a';
            if (curr.children[index]==null)
            {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
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
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */