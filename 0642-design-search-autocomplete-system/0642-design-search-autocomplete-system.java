class AutocompleteSystem {

    private Trie trie;
    private TrieNode currNode;
    private StringBuilder currInput;

    public AutocompleteSystem(String[] sentences, int[] times) {
        this.trie = new Trie();
        int n = sentences.length;
        Map<String, Integer> hotMap = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            hotMap.put(sentences[i], hotMap.getOrDefault(sentences[i], 0)+times[i]);
        }
        for (String sen : hotMap.keySet())
        {
            this.trie.add(sen, hotMap.get(sen));
        }
        this.currNode = this.trie.root;
        this.currInput = new StringBuilder();
    }
    
    public List<String> input(char c) {
        // #
        /** 
        we need to add currinput to trie, and update currnode, currinput
        */
        // everything else
        List<String> result = new ArrayList<>();
        int index = trie.getIndex(c);
        if (c!='#')
        this.currInput.append(c);
        if (this.currNode==null || this.currNode.children[index]==null)
        {
            this.currNode = null;
        }
        if (this.currNode!=null)
        {
            this.currNode = this.currNode.children[index];
            result = this.currNode.getList();
        }
        if (c=='#')
        {
            String sen = currInput.toString();
            this.trie.add(sen, 1);
            this.currNode = this.trie.root;
            this.currInput = new StringBuilder();
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */


class Trie
{
    TrieNode root;

    Trie()
    {
        this.root = new TrieNode();
    }

    public void add(String sentence, int times)
    {
        // System.out.println("adding : "+sentence);
        TrieNode curr = this.root;
        for (char c : sentence.toCharArray())
        {
            int x = getIndex(c);
            if (curr.children[x]==null)
            {
                curr.children[x] = new TrieNode();
            }
            curr.addEntry(sentence, times);
            curr = curr.children[x];
        }
        curr.addEntry(sentence, times);
    }

    public int getIndex(char c)
    {
        int x = c-'a';
        if (x>=0 && x<26)
        {

        }
        else if (c==' ')
        {
            x = 26;
        }
        else
        {
            x = 27;
        }
        return x;
    }
}

class TrieNode
{
    TrieNode[] children;
    Map<String, Integer> map;
    List<String> list;

    TrieNode()
    {
        this.children = new TrieNode[28]; // 26, 27-space, 28-special
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    void addEntry(String sen, int times)
    {
        this.map.put(sen, this.map.getOrDefault(sen, 0)+times);
        computeList();
    }

    void addOne(String sen)
    {
        addEntry(sen, 1);
    }

    void computeList()
    {
        Queue<String> heap = new PriorityQueue<>((a,b)->(map.get(a)!=map.get(b)?map.get(a)-map.get(b):b.compareTo(a)));
        for (String s : this.map.keySet())
        {
            heap.offer(s);
            if (heap.size()>3)
            {
                heap.poll();
            }
        }
        this.list = new ArrayList<>();
        while(heap.isEmpty()==false)
        {
            this.list.add(heap.poll());
        }
        Collections.reverse(this.list);
    }

    List<String> getList()
    {
        return this.list;
    }
}

class Entry
{
    String sentence;
    int times;

    Entry(String sentence, int times)
    {
        this.sentence = sentence;
        this.times = times;
    }

    int compare(Entry e2)
    {
        //times desc
        if (this.times!=e2.times)
        {
            return e2.times-this.times;
        }
        else
        {
            //sentence lexicographic
            return this.sentence.compareTo(e2.sentence);
        }
    }
}