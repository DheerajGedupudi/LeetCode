class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int h : hand)
        {
            map.put(h, map.getOrDefault(h, 0)+1);
        }
        while(map.size()>0)
        {
            int first = map.firstKey();
            int minFreq = Integer.MAX_VALUE;
            for (int i=first; i<first+groupSize; i++)
            {
                Integer freq = map.get(i);
                if (freq==null || freq<1)
                {
                    return false;
                }
                minFreq = Math.min(minFreq, freq);
            }
            for (int i=first; i<first+groupSize; i++)
            {
                map.put(i, map.getOrDefault(i, 0)-minFreq);
                if (map.get(i)==0)
                {
                    map.remove(i);
                }
            }
        }
        return true;
    }
}