class Solution {

    private int result;

    public int pathSum(int[] nums) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int num : nums)
        {
            int depth = num/100;
            int pos = num/10;
            pos %= 10;
            int value = num%10;
            map.putIfAbsent(depth, new HashMap<>());
            map.get(depth).put(pos, value);
        }
        dfs(map, 0, 1, 1);
        return this.result;
    }

    private void dfs(Map<Integer, Map<Integer, Integer>> map, int sum, int depth, int pos)
    {
        if (map.containsKey(depth)==false || map.get(depth).containsKey(pos)==false)
        {
            return;
        }
        int currValue = map.get(depth).get(pos);
        sum += currValue;
        int left = ((pos-1)*2)+1;
        int right = ((pos-1)*2)+2;
        if (map.containsKey(depth+1)==false || (map.get(depth+1).containsKey(left)==false && map.get(depth+1).containsKey(right)==false) )
        {
            //leaf
            this.result += sum;
            return;
        }
        dfs(map, sum, depth+1, left);
        dfs(map, sum, depth+1, right);
        sum -= currValue;
    }
}