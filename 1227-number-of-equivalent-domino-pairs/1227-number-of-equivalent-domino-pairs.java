class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int[] dom : dominoes)
        {
            int min = Math.min(dom[0], dom[1]);
            int max = Math.max(dom[0], dom[1]);
            List<Integer> list = new ArrayList<>();
            list.add(min);
            list.add(max);
            map.put(list, map.getOrDefault(list, 0)+1);
        }
        int count = 0;
        for (int pairs : map.values())
        {
            count += (pairs*(pairs-1))/2;
        }
        return count;
    }
}

/*

[1,2]

*/