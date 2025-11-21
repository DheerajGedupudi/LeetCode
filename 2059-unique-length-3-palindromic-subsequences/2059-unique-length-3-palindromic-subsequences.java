class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            char c = s.charAt(i);
            indexMap.putIfAbsent(c, new ArrayList<>());
            indexMap.get(c).add(i);
        }
        int count = 0;
        for (List<Integer> indexes : indexMap.values())
        {
            if (indexes.size()>1)
            {
                int start = indexes.get(0);
                int end = indexes.get(indexes.size()-1);
                count += getUniqueChars(start, end, indexMap);
            }
        }
        return count;
    }

    private int getUniqueChars(int start, int end, Map<Character, List<Integer>> indexMap)
    {
        int count = 0;
        for (List<Integer> indexes : indexMap.values())
        {
            //get largest lower than end, make sure it is greater than start
            int x = getCeiling(indexes, end-1);
            if (x==-1)
            {
                continue;
            }
            int indexOfChar = indexes.get(x);
            if (indexOfChar>start && indexOfChar<end)
            {
                count++;
            }
        }
        // System.out.println("start : "+start+", end : "+end+", count : "+count);
        return count;
    }

    private int getCeiling(List<Integer> list, int target)
    {
        int low = 0;
        int high = list.size()-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (list.get(mid)<=target)
            {
                best = mid;
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return best;
    }
}


/*





*/