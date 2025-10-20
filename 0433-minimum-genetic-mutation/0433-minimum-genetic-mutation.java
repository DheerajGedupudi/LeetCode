class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        q.offer(startGene);
        visited.add(startGene);
        int levels = 0;
        while(q.isEmpty()==false)
        {
            int size = q.size();
            for (int i=0; i<size; i++)
            {
                String curr = q.poll();
                if (curr.equals(endGene))
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
        return -1;
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