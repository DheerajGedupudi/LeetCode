class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums)
        {
            q.offer(x);
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for (int k : map.keySet())
        {
            int v = map.get(k);
            if (v>1)
            {
                set.add(k);
            }
        }
        int counter = 0;
        // System.out.println(set);
        // System.out.println(q+" -> "+map+" set : "+set+", counter : "+counter);
        while(q.isEmpty()==false && set.size()>0)
        {
            List<Integer> list = new ArrayList<>();
            for (int i=0; i<3 && q.isEmpty()==false; i++)
            {
                int x = q.pollFirst();
                list.add(x);
            }
            boolean flag = false;
            for (int x : list)
            {
                if (set.contains(x))
                {
                    // System.out.println("set contains : "+x);
                    flag = true;
                }
                if (map.get(x)>1)
                {
                    // System.out.println("map more for : "+x+" -> "+map.get(x));
                    flag = true;
                }
            }
            for (int x : list)
            {
                map.put(x, map.get(x)-1);
            }
            for (int x : list)
            {
                if (map.get(x)<=1)
                {
                    set.remove(x);
                }
            }
            counter++;
            // System.out.println(q+" -> "+map+" set : "+set+", counter : "+counter+" flag : "+flag);
        }
        return counter;
        
    }
}