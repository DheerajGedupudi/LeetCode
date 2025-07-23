class Solution {
    public List<String> wordsAbbreviation(List<String> words) {
        Map<String, String> abbMap = new HashMap<>();
        Map<Integer, List<String>> lengthMap = new HashMap<>();
        for (String word : words)
        {
            int len = word.length();
            lengthMap.putIfAbsent(len, new ArrayList<>());
            lengthMap.get(len).add(word);
        }
        for (int len : lengthMap.keySet())
        {
            List<String> sameLengthWordList = lengthMap.get(len);
            Map<Character, List<String>> lastLetterMap = new HashMap<>();
            for (String word : sameLengthWordList)
            {
                char c = word.charAt(len-1);
                lastLetterMap.putIfAbsent(c, new ArrayList<>());
                lastLetterMap.get(c).add(word);
            }
            for (char lastLetter : lastLetterMap.keySet())
            {
                List<String> wordList = lastLetterMap.get(lastLetter);
                Trie trie = new Trie(len);
                Collections.sort(wordList);
                for (String word : wordList)
                {
                    trie.insert(word);
                }
                List<String> abbList = trie.get();
                // System.out.println(wordList+" =>  "+abbList);
                int size = abbList.size();
                for (int i=0; i<size; i++)
                {
                    abbMap.put(wordList.get(i), abbList.get(i));
                }

            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words)
        {
            result.add(abbMap.get(word));
        }
        return result;
    }
}

class Trie
{
    TrieNode root;
    int wordLength;
    List<String> result;

    Trie(int length)
    {
        this.root = new TrieNode();
        this.wordLength = length;
        this.result = new ArrayList<>();
    }

    void insert(String s)
    {
        TrieNode curr = this.root;
        for (char c : s.toCharArray())
        {
            int index = c-'a';
            if (curr.children[index]==null)
            {
                curr.children[index] = new TrieNode();
            }
            curr.count++;
            curr.set.add(s);
            curr = curr.children[index];
        }
        curr.count++;
        curr.set.add(s);
        curr.flag = true;
    }

    List<String> get()
    {
        this.result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<26; i++)
        {
            TrieNode curr = this.root.children[i];
            if (curr!=null)
            {
                char c = (char)(i+'a');
                sb.append(c);
                dfs(curr, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return this.result;
    }

    void dfs(TrieNode node, StringBuilder sb)
    {
        if (node.count==1)
        {
            String s = sb.toString();
            int diff = this.wordLength-(s.length()+1);
            String lastWord = node.set.get(0);
            String word = lastWord;
            if (diff>1)
            {
                word = s+diff+lastWord.charAt(lastWord.length()-1);
            }
            this.result.add(word);
            return;
        }
        for (int i=0; i<26; i++)
        {
            if (node.children[i]!=null)
            {
                char c = (char)(i+'a');
                sb.append(c);
                dfs(node.children[i], sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
}

class TrieNode
{
    TrieNode[] children;
    int count;
    boolean flag;
    List<String> set;

    TrieNode()
    {
        this.children = new TrieNode[26];
        this.count = 0;
        this.flag = false;
        this.set = new ArrayList<>();
    }
}