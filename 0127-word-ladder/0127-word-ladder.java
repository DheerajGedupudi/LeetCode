class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        String[] bank = new String[wordList.size()];
        for (int i=0; i<wordList.size(); i++)
        {
            bank[i] = wordList.get(i);
        }
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int levels = 1;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                String curr = q.poll();
                if (curr.equals(endWord))
                {
                    return levels;
                }
                List<String> list = get(curr, bank);
                for (String s : list)
                {
                    if (visited.contains(s)==false)
                    {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            levels++;
        }
        return 0;
    }

    private List<String> get(String start, String[] bank)
    {
        List<String> list = new ArrayList<>();
        for (String s : bank)
        {
            if (oneAway(s,start))
            {
                list.add(s);
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