class Solution {

    private List<List<String>> result;

    public List<List<String>> wordSquares(String[] words) {
        Trie trie = new Trie();
        for (String w : words)
        {
            trie.insert(w);
        }
        this.result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        for (String w : words)
        {
            path.add(w);
            dfs(path, trie);
            path.remove(path.size()-1);
        }
        return this.result;
    }

    private void dfs(List<String> path, Trie trie)
    {
        int n = path.get(0).length();
        int size = path.size();
        if (n==size)
        {
            this.result.add(new ArrayList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        int col = size;
        for (int i=0; i<size; i++)
        {
            sb.append(path.get(i).charAt(col));
        }
        String prefix = sb.toString();
        for (String s : trie.getPrefix(prefix))
        {
            path.add(s);
            dfs(path, trie);
            path.remove(path.size()-1);
        }
    }
}

class Trie
{
    TrieNode root;

    Trie()
    {
        this.root = new TrieNode();
    }

    void insert(String s)
    {
        TrieNode curr = this.root;
        for (char c : s.toCharArray())
        {
            int i = c-'a';
            if (curr.children[i]==null)
            {
                curr.children[i] = new TrieNode();
            }
            curr.list.add(s);
            curr = curr.children[i];
        }
        curr.list.add(s);
    }

    List<String> getPrefix(String s)
    {
        TrieNode curr = this.root;
        for (char c : s.toCharArray())
        {
            int i = c-'a';
            if (curr.children[i]==null)
            {
                return new ArrayList<>();
            }
            curr = curr.children[i];
        }
        return curr.list;
    }

}

class TrieNode
{
    TrieNode[] children;
    List<String> list;

    TrieNode()
    {
        this.children = new TrieNode[26];
        this.list = new ArrayList<>();
    }
}

/*

["area","lead","wall","lady","ball"]

k = 0

k = 1

ball
area
lead
lady

wall
area
lead
lady

[["ball","area","lead","lady"],
 ["wall","area","lead","lady"]]

*/