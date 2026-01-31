class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        Trie trie = new Trie();
        trie.addAll(original);
        trie.addAll(changed);
        int num = trie.getCount();
        long[][] matrix = getAllPairShortestPath(trie, original, changed, cost);
        int len = source.length();
        long INF = (long)Math.pow(10, 17);
        long[] dp = new long[len+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i=0; i<len; i++)
        {
            if (dp[i]==INF)
            {
                continue;
            }
            if (source.charAt(i)==target.charAt(i))
            {
                dp[i+1] = Math.min(dp[i], dp[i+1]);
            }
            TrieNode curr1 = trie.root;
            TrieNode curr2 = trie.root;
            for (int j=i; j<len; j++)
            {
                int c = source.charAt(j);
                int d = target.charAt(j);
                int x = c-'a';
                int y = d-'a';
                curr1 = curr1.children[x];
                curr2 = curr2.children[y];
                if (curr1==null || curr2==null)
                {
                    break;
                }
                int id1 = curr1.id;
                int id2 = curr2.id;
                if (id1!=-1 && id2!=-1)
                {
                    dp[j+1] = Math.min(dp[j+1], dp[i]+matrix[id1][id2]);
                }

            }
        }
        // System.out.println(Arrays.toString(dp));
        if (dp[len]==INF)
        {
            return -1;
        }
        return dp[len];
    }

    private long[][] getAllPairShortestPath(Trie trie, String[] original, String[] changed, int[] cost)
    {
        int n = cost.length;
        long INF = (long)Math.pow(10, 17);
        int num = trie.getCount();
        long[][] matrix = new long[num][num];
        for (int i=0; i<num; i++)
        {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }
        for (int i=0; i<n; i++)
        {
            int id1 = trie.getID(original[i]);
            int id2 = trie.getID(changed[i]);
            matrix[id1][id2] = Math.min(matrix[id1][id2], cost[i]);
        }
        for (int k=0; k<num; k++)
        {
            for (int i=0; i<num; i++)
            {
                if (matrix[i][k]==INF)
                {
                    continue;
                }
                for (int j=0; j<num; j++)
                {
                    long cost2 = matrix[i][k]+matrix[k][j];
                    if (cost2<INF && cost2<matrix[i][j])
                    {
                        matrix[i][j] = cost2;
                    }
                }
            }
        }
        return matrix;
    }
}

class Trie
{
    TrieNode root;
    int idCounter;

    Trie()
    {
        this.root = new TrieNode();
        this.idCounter = 0;
    }

    public void addAll(String[] array)
    {
        for (String word : array)
        {
            add(word);
        }
    }

    public void add(String word)
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
        if (curr.id==-1)
        {
            curr.id = this.idCounter++;
        }
    }

    public int getID(String word)
    {
        TrieNode curr = this.root;
        for (char c : word.toCharArray())
        {
            if (curr.children[c-'a']==null)
            {
                return -1;
            }
            curr = curr.children[c-'a'];
        }
        return curr.id;
    }

    public int getCount()
    {
        return this.idCounter;
    }
}

class TrieNode
{
    TrieNode[] children;
    int id;
    boolean flag;

    TrieNode()
    {
        this.children = new TrieNode[26];
        this.id = -1;
        this.flag = false;
    }
}