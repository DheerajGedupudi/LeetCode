class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int right = 0;
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>(); 
        int max = 0;
        while(right<n)
        {
            int x = fruits[right];
            map.put(x, map.getOrDefault(x, 0)+1);
            if (map.size()<=2)
            {
                int len = right - left + 1;
                max = Math.max(max, len);
            }
            while(map.size()>2)
            {
                int y = fruits[left];
                map.put(y, map.get(y)-1);
                if (map.get(y)==0)
                {
                    map.remove(y);
                }
                left++;
            }
            if (map.size()<=2)
            {
                int len = right - left + 1;
                max = Math.max(max, len);
            }
            right++;
        }
        return max;
    }
}