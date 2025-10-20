class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList)
        {
            wordSet.add(s);
        } 
        wordSet.remove(beginWord);
        int n = wordSet.size()+1;
        String[] bank = new String[n];
        int ind = 0;
        for (String s : wordSet)
        {
            bank[ind++] = s;
        }
        bank[n-1] = beginWord;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        q.offer(n-1);
        visited[n-1] = true;
        int levels = 1;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                int curr = q.poll();
                if (bank[curr].equals(endWord))
                {
                    return levels;
                }
                List<Integer> list = get(curr, bank);
                for (int index : list)
                {
                    if (visited[index]==false)
                    {
                        q.offer(index);
                        visited[index] = true;
                    }
                }
            }
            levels++;
        }
        return 0;
    }

    private List<Integer> get(int index, String[] bank)
    {
        List<Integer> list = new ArrayList<>();
        int n = bank.length;
        for (int i=0; i<n; i++)
        {
            if (oneAway(bank[i], bank[index]))
            {
                list.add(i);
            }
        }
        return list;
    } 

    private boolean oneAway(String a, String b)
    {
        int count = 0;
        int lenA = a.length();
        int lenB = b.length();
        if (lenA!=lenB)
        {
            return false;
        }
        for (int i=0; i<lenA; i++)
        {
            if (a.charAt(i)!=b.charAt(i))
            {
                count++;
            }
        }
        return count==1;
    }
}