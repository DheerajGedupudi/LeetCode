class Solution {
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int lens = source.length();
        int lent = target.length();
        for (int i=0; i<lens; i++)
        {
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }
        int count = 1;
        int lastUsedIndex = -1;
        for (char c : target.toCharArray())
        {
            int next = getNextGreater(map.getOrDefault(c, new ArrayList<>()), lastUsedIndex);
            if (next>lastUsedIndex)
            {
                lastUsedIndex = next;
            }
            else
            {
                count++;
                if (map.containsKey(c)==false)
                {
                    return -1;
                }
                lastUsedIndex = map.get(c).get(0);
            }
            // System.out.println("c : "+c+" lastUsed : "+lastUsedIndex+" count : "+count);
        }
        return count;

    }

    private int getNextGreater(List<Integer> list, int x)
    {
        int n = list.size();
        int low = 0;
        int high = n-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            int num = list.get(mid);
            if (num>x)
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        if (best==-1)
        {
            return -1;
        }
        return list.get(best);
    }
}



/*

xyz
012

target
. xzyxz
 [02102]

ans = 3

*/