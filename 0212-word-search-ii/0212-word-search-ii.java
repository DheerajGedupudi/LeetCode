class Solution {

    private int[][] dirs;
    private List<String> result;

    public List<String> findWords(char[][] board, String[] words) {
        this.dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        this.result = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words)
        {
            trie.insert(word);
        }
        found(board, trie);
        return this.result;
    }

    private boolean found(char[][] board, Trie trie)
    {
        int n = board.length;
        int m = board[0].length;
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (found(board, i, j, trie.root, new boolean[n][m], new StringBuilder()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean found(char[][] board, int x, int y, TrieNode node, boolean[][] visited, StringBuilder sb)
    {
        int n = board.length;
        int m = board[0].length;
        int trieIndex = board[x][y]-'a';
        //check if curr char is present in trie, if yes, go there.
        if (node.children[trieIndex]!=null)
        {
            sb.append(board[x][y]);
            visited[x][y] = true;
            node = node.children[trieIndex];
            if (node.flag)
            {
                node.flag = false;
                this.result.add(sb.toString());
            }
            
            for (int[] dir : dirs)
            {
                int r = x+dir[0];
                int c = y+dir[1];
                if (r>=0 && r<n && c>=0 && c<m && visited[r][c]==false)
                {
                    int childTrieIndex = board[r][c]-'a';
                    if (found(board, r, c, node, visited, sb))
                    {
                        return true;
                    }
                }
            }
            sb.deleteCharAt(sb.length()-1);
            visited[x][y] = false;
        }
        return false;
    }
}

class Trie
{
    TrieNode root;

    Trie()
    {
        this.root = new TrieNode();
    }

    void insert(String word)
    {
        TrieNode curr = this.root;
        for (char c : word.toCharArray())
        {
            if (curr.children[c-'a']==null)
            {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.flag = true;
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